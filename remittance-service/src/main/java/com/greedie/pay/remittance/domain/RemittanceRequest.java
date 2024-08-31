package com.greedie.pay.remittance.domain;

import com.greedie.pay.remittance.domain.enums.RemittanceRequestStatus;
import com.greedie.pay.remittance.domain.enums.RemittanceType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class RemittanceRequest {
    private String fromMembershipId;

    private String toMembershipId;

    private String toBankName;

    private String toBankAccountNumber;

    @Setter
    private RemittanceType remittanceType;

    @Setter
    private RemittanceRequestStatus remittanceRequestStatus;

    private BigDecimal amount;
}
