package com.greedie.pay.banking.adapter.out.external;

import com.greedie.pay.banking.application.port.out.FirmbankingServicePort;
import com.greedie.pay.common.ExternalSystemAdapter;
import org.springframework.stereotype.Service;

@Service
@ExternalSystemAdapter
public class FirmbankingServiceAdaptor implements FirmbankingServicePort {
    @Override
    public FirmbankingServiceResponse send(FirmbankingServiceRequest request) {
        return null;
    }
}
