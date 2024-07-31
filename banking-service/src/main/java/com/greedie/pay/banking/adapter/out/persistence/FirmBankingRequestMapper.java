package com.greedie.pay.banking.adapter.out.persistence;

import com.greedie.pay.banking.domain.FirmbankingRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FirmBankingRequestMapper {
    public FirmbankingRequest mapDomainToEntity(final FirmbankingRequestEntity entity) {
        return FirmbankingRequest.generateFirmbankingRequest(
                entity.getToBankName(),
                entity.getFromBankAccountNumber(),
                entity.getToBankName(),
                entity.getToBankAccountNumber(),
                entity.getMoneyAmount(),
                entity.getFirmbankingRequestStatus()
        );
    }
}
