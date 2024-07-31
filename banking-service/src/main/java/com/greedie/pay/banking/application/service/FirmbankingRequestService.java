package com.greedie.pay.banking.application.service;

import com.greedie.pay.banking.adapter.out.external.FirmbankingServiceRequest;
import com.greedie.pay.banking.adapter.out.external.FirmbankingServiceResponse;
import com.greedie.pay.banking.adapter.out.persistence.FirmBankingRequestMapper;
import com.greedie.pay.banking.adapter.out.persistence.FirmbankingRequestEntity;
import com.greedie.pay.banking.application.port.in.FirmbankingRequestCommand;
import com.greedie.pay.banking.application.port.in.FirmbankingRequestUseCase;
import com.greedie.pay.banking.application.port.out.FirmbankingRequestPersistencePort;
import com.greedie.pay.banking.application.port.out.FirmbankingServicePort;
import com.greedie.pay.banking.domain.FirmbankingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FirmbankingRequestService implements FirmbankingRequestUseCase {
    private final FirmBankingRequestMapper mapper;
    private final FirmbankingRequestPersistencePort firmbankingRequestPersistencePort;
    private final FirmbankingServicePort firmbankingServicePort;

    @Override
    public FirmbankingRequest requestFirmbankingCheckAccount(FirmbankingRequestCommand command) {
        FirmbankingRequestEntity firmbankingRequest = firmbankingRequestPersistencePort.createFirmbankingRequest(
                command.getFromBankName(),
                command.getFromAccountNumber(),
                command.getToBankName(),
                command.getToAccountNumber(),
                command.getMoneyAmount(),
                FirmbankingRequest.FirmbankingRequestStatus.REQUEST
        );

        FirmbankingServiceResponse response = firmbankingServicePort.send(new FirmbankingServiceRequest(
                command.getFromBankName(),
                command.getFromAccountNumber(),
                command.getToBankName(),
                command.getToAccountNumber()
        ));

        if(response.status() == 0) {
            firmbankingRequest.setFirmbankingRequestStatus(FirmbankingRequest.FirmbankingRequestStatus.COMPLETED);
        } else {
            firmbankingRequest.setFirmbankingRequestStatus(FirmbankingRequest.FirmbankingRequestStatus.FAIL);
        }
        return mapper.mapDomainToEntity(firmbankingRequest);
    }
}
