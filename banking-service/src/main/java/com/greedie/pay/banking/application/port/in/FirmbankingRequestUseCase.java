package com.greedie.pay.banking.application.port.in;

import com.greedie.pay.banking.domain.FirmbankingRequest;

public interface FirmbankingRequestUseCase {
    FirmbankingRequest requestFirmbankingCheckAccount(FirmbankingRequestCommand command);
}
