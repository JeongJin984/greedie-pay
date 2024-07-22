package com.greedie.pay.banking.adapter.out.persistence;

import com.greedie.pay.banking.domain.FirmbankingRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "firmbanking_request")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FirmbankingRequestEntity {
    @Id
    private String requestId;

    private String fromBankName;
    private String fromBankAccountNumber;
    private String toBankName;
    private String toBankAccountNumber;
    private BigDecimal moneyAmount;
    @Setter
    private FirmbankingRequest.FirmbankingRequestStatus firmbankingRequestStatus;

}
