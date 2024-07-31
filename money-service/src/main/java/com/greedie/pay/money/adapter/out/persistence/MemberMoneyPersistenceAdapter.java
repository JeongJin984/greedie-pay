package com.greedie.pay.money.adapter.out.persistence;

import com.greedie.pay.common.PersistenceAdapter;
import com.greedie.pay.money.application.port.out.MemberMoneyPersistencePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@PersistenceAdapter
@RequiredArgsConstructor
@Slf4j
public class MemberMoneyPersistenceAdapter implements MemberMoneyPersistencePort {
    private final MemberMoneyJpaRepository memberMoneyJpaRepository;

    @Override
    public MemberMoneyJpaEntity createMemberMoney(String membershipId, String currency, BigDecimal amount) {
        return memberMoneyJpaRepository.save(new MemberMoneyJpaEntity(
                UUID.randomUUID().toString(),
                membershipId,
                amount,
                currency
        ));
    }

    @Override
    public MemberMoneyJpaEntity chargeMemberMoney(String membershipId, String currency, BigDecimal amount) {
        MemberMoneyJpaEntity memberMoney = memberMoneyJpaRepository.findByOwnerMemberIdAndCurrency(membershipId, currency)
                .orElseGet(() -> {
                    log.warn("Charging target MemberMoney not found membershipId={} currency={}", membershipId, currency);
                    return new MemberMoneyJpaEntity(UUID.randomUUID().toString(), membershipId, BigDecimal.ZERO, currency);
                });
        memberMoney.chargeBalance(amount);
        return memberMoneyJpaRepository.save(memberMoney);
    }

    @Override
    public MemberMoneyJpaEntity consumeMemberMoney(String membershipId, String currency, BigDecimal amount) throws IllegalStateException {
        MemberMoneyJpaEntity memberMoney = memberMoneyJpaRepository.findByOwnerMemberIdAndCurrency(membershipId, currency)
                .orElseGet(() -> {
                    log.warn("Consume target MemberMoney not found membershipId={} currency={}", membershipId, currency);
                    return new MemberMoneyJpaEntity(UUID.randomUUID().toString(), membershipId, BigDecimal.ZERO, currency);
                });
        memberMoney.consumeBalance(amount);

        return memberMoneyJpaRepository.save(memberMoney);
    }
}
