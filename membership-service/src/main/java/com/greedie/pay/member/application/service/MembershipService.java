package com.greedie.pay.member.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greedie.pay.common.event.InitializeMemberMoneyEvent;
import com.greedie.pay.member.adapter.out.persistence.MembershipJpaEntity;
import com.greedie.pay.member.application.port.in.SignUpRequestCommand;
import com.greedie.pay.member.application.port.in.SignUpRequestUseCase;
import com.greedie.pay.member.application.port.out.SignUpPersistencePort;
import com.greedie.pay.member.domain.Membership;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class MembershipService implements SignUpRequestUseCase {
    private final SignUpPersistencePort signUpPersistencePort;
    private final KafkaTemplate<String, InitializeMemberMoneyEvent> kafkaTemplate;
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Membership signUp(SignUpRequestCommand command) {
        Membership membership = new Membership(
                UUID.randomUUID().toString(),
                command.getUsername(),
                command.getPassword(),
                command.getEmail(),
                command.getAddress(),
                true,
                command.isCorp()
        );

        signUpPersistencePort.registerMember(membership);

        kafkaTemplate.send("member-signup-initialize", new InitializeMemberMoneyEvent(membership.getMembershipId(), "0", "KRW"))
                .whenComplete((action, throwable) -> {
                    if(throwable == null) {
                        log.info("membership signup action completed: {}", action);
                    } else {
                        log.error("membership signup action failed: {}", throwable, throwable);
                    }
                });

        return membership;
    }
}
