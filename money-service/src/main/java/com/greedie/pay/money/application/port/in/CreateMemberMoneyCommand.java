package com.greedie.pay.money.application.port.in;

import com.greedie.pay.common.SelfValidating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class CreateMemberMoneyCommand extends SelfValidating<CreateMemberMoneyCommand> {
    @NotNull
    @NotBlank
    private final String membershipId;

    @NotNull
    private final String currency;

    @NotNull
    private final BigDecimal amount;

    public CreateMemberMoneyCommand(String membershipId, String currency, BigDecimal amount) {
        this.membershipId = membershipId;
        this.currency = currency;
        this.amount = amount;
        validateSelf();
    }
}
