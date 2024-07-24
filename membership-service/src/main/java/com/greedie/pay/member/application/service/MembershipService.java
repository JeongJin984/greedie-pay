package com.greedie.pay.member.application.service;

import com.greedie.pay.member.adapter.out.persistence.MembershipJpaEntity;
import com.greedie.pay.member.application.port.in.SignUpRequestCommand;
import com.greedie.pay.member.application.port.in.SignUpRequestUseCase;
import com.greedie.pay.member.application.port.out.SignUpPersistencePort;
import com.greedie.pay.member.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MembershipService implements SignUpRequestUseCase {
    private final SignUpPersistencePort signUpPersistencePort;

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

        return membership;
    }
}
