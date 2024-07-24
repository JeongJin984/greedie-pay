package com.greedie.pay.member.application.port.in;

import com.greedie.pay.member.domain.Membership;

public interface SignUpRequestUseCase {
    Membership signUp(SignUpRequestCommand command);
}
