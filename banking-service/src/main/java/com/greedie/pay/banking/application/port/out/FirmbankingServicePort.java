package com.greedie.pay.banking.application.port.out;


import com.greedie.pay.banking.adapter.out.external.FirmbankingServiceRequest;
import com.greedie.pay.banking.adapter.out.external.FirmbankingServiceResponse;

public interface FirmbankingServicePort {
    FirmbankingServiceResponse send(FirmbankingServiceRequest request);
}
