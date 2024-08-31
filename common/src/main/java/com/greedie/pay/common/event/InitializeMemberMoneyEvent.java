package com.greedie.pay.common.event;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record InitializeMemberMoneyEvent (
        String membershipId,
        String initAmount,
        String currency
) {
}
