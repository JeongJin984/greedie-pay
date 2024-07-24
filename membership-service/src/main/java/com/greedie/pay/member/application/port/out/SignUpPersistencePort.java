package com.greedie.pay.member.application.port.out;

import com.greedie.pay.member.adapter.out.persistence.MembershipJpaEntity;
import com.greedie.pay.member.domain.Membership;

public interface SignUpPersistencePort {
    MembershipJpaEntity registerMember(Membership membership);
}
