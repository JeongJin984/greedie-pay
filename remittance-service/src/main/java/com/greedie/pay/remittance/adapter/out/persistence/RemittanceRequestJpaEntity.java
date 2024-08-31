package com.greedie.pay.remittance.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemittanceRequestJpaEntity {
    @Id
    private String remittanceRequestId;
    private String fromMembershipId;
    private String toMembershipId;
    private String toBankName;
    private String toBankAccountNumber;
    private int remittanceType;
    private BigDecimal amount;
    private String remittanceStatus;
}
