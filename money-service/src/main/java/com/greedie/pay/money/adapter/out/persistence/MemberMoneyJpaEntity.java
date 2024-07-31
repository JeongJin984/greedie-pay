package com.greedie.pay.money.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

@Entity
@Getter
@Table(name = "member_money")
@AllArgsConstructor
@NoArgsConstructor
public class MemberMoneyJpaEntity {
    private static final Logger log = LoggerFactory.getLogger(MemberMoneyJpaEntity.class);
    @Id
    private String memberMoneyId;

    private String ownerMemberId;

    private BigDecimal balance;

    private String currency;

    public void chargeBalance(BigDecimal amount) {
        this.balance = balance.add(amount);
    }

    public void consumeBalance(BigDecimal amount) throws IllegalStateException {
        if(balance.compareTo(amount) < 0) {
            log.error("current balance={} / consume amount={}", balance, amount);
            throw new IllegalStateException("not enough money");
        } else {
            this.balance = balance.subtract(amount);
        }

    }
}
