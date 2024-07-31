package com.greedie.pay.banking.application.port.out;


import com.greedie.pay.banking.adapter.out.persistence.FirmbankingRequestEntity;
import com.greedie.pay.banking.domain.FirmbankingRequest;

import java.math.BigDecimal;

public interface FirmbankingRequestPersistencePort {
    FirmbankingRequestEntity createFirmbankingRequest(
            String fromBankName,
            String fromBankAccountNumber,
            String toBankName,
            String toBankAccountNumber,
            BigDecimal moneyAmount,
            FirmbankingRequest.FirmbankingRequestStatus firmbankingRequestStatus
    );
}
