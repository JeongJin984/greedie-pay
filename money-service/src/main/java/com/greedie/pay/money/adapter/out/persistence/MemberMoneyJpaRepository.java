package com.greedie.pay.money.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberMoneyJpaRepository extends JpaRepository<MemberMoneyJpaEntity, String> {
    Optional<MemberMoneyJpaEntity> findByOwnerMemberIdAndCurrency(String membershipId, String currency);
}
