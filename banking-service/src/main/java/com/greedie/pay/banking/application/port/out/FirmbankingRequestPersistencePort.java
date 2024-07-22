package com.greedie.pay.banking.application.port.out;


import com.greedie.pay.banking.adapter.out.persistence.FirmbankingRequestEntity;
import com.greedie.pay.banking.domain.FirmbankingRequest;

public interface FirmbankingRequestPersistencePort {
    FirmbankingRequestEntity createFirmbankingRequest(
            FirmbankingRequest.FromBankName fromBankName,
            FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber,
            FirmbankingRequest.ToBankName toBankName,
            FirmbankingRequest.ToBankAccountNumber toBankAccountNumber,
            FirmbankingRequest.MoneyAmount moneyAmount,
            FirmbankingRequest.FirmbankingRequestStatus firmbankingRequestStatus
    );
}
