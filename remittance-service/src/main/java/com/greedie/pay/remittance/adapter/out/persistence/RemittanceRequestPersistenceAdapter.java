package com.greedie.pay.remittance.adapter.out.persistence;

import com.greedie.pay.common.PersistenceAdapter;
import com.greedie.pay.remittance.application.port.out.RequestRemittancePort;
import com.greedie.pay.remittance.domain.RemittanceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@PersistenceAdapter
@RequiredArgsConstructor
public class RemittanceRequestPersistenceAdapter implements RequestRemittancePort {
    private final RemittanceRequestRepository remittanceRequestRepository;

    @Override
    public RemittanceRequestJpaEntity createRemittanceRequestHistory(RemittanceRequest request) {
        return remittanceRequestRepository.save(RemittanceRequestJpaEntity.builder()
                .fromMembershipId(request.getFromMembershipId())
                .toMembershipId(request.getToMembershipId())
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .amount(request.getAmount())
                .remittanceType(request.getRemittanceType())
                .build());
    }
}
