package com.greedie.pay.money.application.service;

import com.greedie.pay.common.command.RequestFirmbankingCommand;
import com.greedie.pay.money.adapter.out.persistence.MemberMoneyJpaEntity;
import com.greedie.pay.money.adapter.out.service.RegisteredBankAccount;
import com.greedie.pay.money.application.port.in.ChargeMemberMoneyCommand;
import com.greedie.pay.money.application.port.in.ConsumeMemberMoneyCommand;
import com.greedie.pay.money.application.port.in.CreateMemberMoneyCommand;
import com.greedie.pay.money.application.port.in.MemberMoneyUseCase;
import com.greedie.pay.money.application.port.out.GetRegisteredBankAccount;
import com.greedie.pay.money.application.port.out.MemberMoneyPersistencePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class MemberMoneyService implements MemberMoneyUseCase {
    private final MemberMoneyPersistencePort memberMoneyPersistencePort;
    private final GetRegisteredBankAccount getRegisteredBankAccount;
    private final KafkaTemplate<String, RequestFirmbankingCommand> kafkaTemplate;

    @Override
    public void chargeMemberMoney(ChargeMemberMoneyCommand command) {
        MemberMoneyJpaEntity memberMoney = memberMoneyPersistencePort.findMyMemberMoney(command.getTargetMembershipId(), command.getCurrency());
        RegisteredBankAccount registeredBankAccount = getRegisteredBankAccount.getRegisteredBankAccount(memberMoney.getOwnerMemberId());

        if(!registeredBankAccount.isLinkedStatusIsValid()) {
            log.error("OwnerId : {}, Registered BankAccount status is not valid. accountId : {}", memberMoney.getOwnerMemberId(), registeredBankAccount.getRegisteredBankAccountId());
            return;
        }

        kafkaTemplate.send("firmbanking-request", new RequestFirmbankingCommand(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                command.getTargetMembershipId(),
                "greedie-corp-bank",
                "123456789",
                registeredBankAccount.getBankName(),
                registeredBankAccount.getBankAccountNumber(),
                command.getAmount().toString()
        )).whenComplete((result, ex) -> {
            if(ex == null) {
                log.error("Error occurred when sending firmbanking command : {}", command);
            } else {
                MemberMoneyJpaEntity memberMoneyJpaEntity = memberMoneyPersistencePort.chargeMemberMoney(
                        command.getTargetMembershipId(),
                        command.getCurrency(),
                        command.getAmount()
                );

                if(memberMoneyJpaEntity == null) {
                    kafkaTemplate.send("firmbanking-request", new RequestFirmbankingCommand());
                }
            }
        });
    }

    @Override
    public void createMemberMoney(CreateMemberMoneyCommand command) {
        memberMoneyPersistencePort.createMemberMoney(command.getMembershipId(), command.getCurrency(), command.getAmount());
    }

    @Override
    public void consumeMemberMoney(ConsumeMemberMoneyCommand command) {
        memberMoneyPersistencePort.consumeMemberMoney(command.getTargetMembershipId(), command.getCurrency(), command.getAmount());
    }
}
