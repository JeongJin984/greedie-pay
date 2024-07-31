package com.greedie.pay.money.application.port.in;

import com.greedie.pay.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ChargeMemberMoneyCommand extends SelfValidating<ChargeMemberMoneyCommand> {
    @NotNull
    private final String targetMembershipId;

    @NotNull
    private final String currency;

    @NotNull
    private final BigDecimal amount;

    public ChargeMemberMoneyCommand(String targetMembershipId, String currency, BigDecimal amount) {
        this.targetMembershipId = targetMembershipId;
        this.currency = currency;
        this.amount = amount;
        validateSelf();
    }
}
