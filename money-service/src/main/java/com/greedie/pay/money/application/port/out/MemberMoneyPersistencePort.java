package com.greedie.pay.money.application.port.out;

import com.greedie.pay.money.adapter.out.persistence.MemberMoneyJpaEntity;

import java.math.BigDecimal;

public interface MemberMoneyPersistencePort {
    MemberMoneyJpaEntity createMemberMoney(String membershipId, String currency, BigDecimal amount);
    MemberMoneyJpaEntity chargeMemberMoney(String membershipId, String currency, BigDecimal amount);
    MemberMoneyJpaEntity consumeMemberMoney(String membershipId, String currency, BigDecimal amount);
}
