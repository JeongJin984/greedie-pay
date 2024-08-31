package com.greedie.pay.money.adapter.kafka;

import com.greedie.pay.common.event.InitializeMemberMoneyEvent;
import com.greedie.pay.money.application.port.in.CreateMemberMoneyCommand;
import com.greedie.pay.money.application.port.in.MemberMoneyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class MoneyInitializeSaga {
    private final MemberMoneyUseCase memberMoneyUseCase;

    @KafkaListener(id = "moneyInitialize", topics = "member-signup-initialize")
    public void moneyInitialize(InitializeMemberMoneyEvent event) {
        memberMoneyUseCase.createMemberMoney(new CreateMemberMoneyCommand(
                event.membershipId(),
                event.currency(),
                new BigDecimal(event.currency())
        ));
    }
}
