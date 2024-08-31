package com.greedie.pay.remittance.application.port.in;

import com.greedie.pay.common.UseCase;
import com.greedie.pay.remittance.domain.RemittanceRequest;

@UseCase
public interface RequestRemittanceUseCase {

    RemittanceRequest requestMemberRemittance(RemittanceRequest remittanceRequest);
}
