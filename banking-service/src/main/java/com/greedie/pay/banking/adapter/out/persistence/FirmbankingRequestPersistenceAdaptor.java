package com.greedie.pay.banking.adapter.out.persistence;

import com.greedie.pay.banking.application.port.out.FirmbankingRequestPersistencePort;
import com.greedie.pay.banking.domain.FirmbankingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FirmbankingRequestPersistenceAdaptor implements FirmbankingRequestPersistencePort {
    private final FirmbankingRequestRepository firmbankingRequestRepository;

    @Override
    public FirmbankingRequestEntity createFirmbankingRequest(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, BigDecimal moneyAmount, FirmbankingRequest.FirmbankingRequestStatus firmbankingRequestStatus) {
        return firmbankingRequestRepository.save(
                new FirmbankingRequestEntity(
                        UUID.randomUUID().toString(),
                        fromBankName,
                        fromBankAccountNumber,
                        toBankName,
                        toBankAccountNumber,
                        moneyAmount,
                        firmbankingRequestStatus
                )
        );
    }
}
