package com.greedie.pay.money.application.service;

import com.greedie.pay.money.application.port.in.ChargeMemberMoneyCommand;
import com.greedie.pay.money.application.port.in.ConsumeMemberMoneyCommand;
import com.greedie.pay.money.application.port.in.CreateMemberMoneyCommand;
import com.greedie.pay.money.application.port.in.MemberMoneyUseCase;
import com.greedie.pay.money.application.port.out.MemberMoneyPersistencePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberMoneyService implements MemberMoneyUseCase {
    private final MemberMoneyPersistencePort memberMoneyPersistencePort;

    @Override
    public void chargeMemberMoney(ChargeMemberMoneyCommand command) {
        memberMoneyPersistencePort.chargeMemberMoney(command.getTargetMembershipId(), command.getCurrency(), command.getAmount());
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
