package com.greedie.pay.banking.adapter.out.persistence;

import com.greedie.pay.banking.application.port.out.FirmbankingRequestPersistencePort;
import com.greedie.pay.banking.domain.FirmbankingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FirmbankingRequestPersistenceAdaptor implements FirmbankingRequestPersistencePort {
    private final FirmbankingRequestRepository firmbankingRequestRepository;

    @Override
    public FirmbankingRequestEntity createFirmbankingRequest(FirmbankingRequest.FromBankName fromBankName, FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber, FirmbankingRequest.ToBankName toBankName, FirmbankingRequest.ToBankAccountNumber toBankAccountNumber, FirmbankingRequest.MoneyAmount moneyAmount, FirmbankingRequest.FirmbankingRequestStatus firmbankingRequestStatus) {
        return firmbankingRequestRepository.save(
                new FirmbankingRequestEntity(
                        UUID.randomUUID().toString(),
                        fromBankName.fromBankName(),
                        fromBankAccountNumber.fromBankAccountNumber(),
                        toBankName.toBankName(),
                        toBankAccountNumber.toBankAccountNumber(),
                        moneyAmount.moneyAmount(),
                        firmbankingRequestStatus
                )
        );
    }
}
