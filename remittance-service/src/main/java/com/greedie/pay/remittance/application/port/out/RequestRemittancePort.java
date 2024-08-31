package com.greedie.pay.remittance.application.port.out;

import com.greedie.pay.remittance.adapter.out.persistence.RemittanceRequestJpaEntity;
import com.greedie.pay.remittance.domain.RemittanceRequest;

public interface RequestRemittancePort {
    RemittanceRequestJpaEntity createRemittanceRequestHistory(RemittanceRequest request);
}
