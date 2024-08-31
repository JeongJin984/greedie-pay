package com.greedie.pay.remittance.application.serivce;

import com.greedie.pay.remittance.adapter.out.persistence.RemittanceRequestJpaEntity;
import com.greedie.pay.remittance.application.port.in.RequestRemittanceUseCase;
import com.greedie.pay.remittance.application.port.out.RequestRemittancePort;
import com.greedie.pay.remittance.application.port.out.banking.BankingPort;
import com.greedie.pay.remittance.application.port.out.membership.MembershipPort;
import com.greedie.pay.remittance.application.port.out.membership.MembershipStatus;
import com.greedie.pay.remittance.application.port.out.money.MemberMoneyPort;
import com.greedie.pay.remittance.domain.RemittanceRequest;
import com.greedie.pay.remittance.domain.enums.RemittanceRequestStatus;
import com.greedie.pay.remittance.domain.enums.RemittanceType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.hasText;

@Service
@RequiredArgsConstructor
public class RequestRemittanceService implements RequestRemittanceUseCase {
    private final RequestRemittancePort requestRemittancePort;
    private final MembershipPort membershipPort;
    private final MemberMoneyPort memberMoneyPort;
    private final BankingPort bankingPort;

    @Override
    public RemittanceRequest requestMemberRemittance(RemittanceRequest remittanceRequest) {
        MembershipStatus membershipStatus = membershipPort.getMembershipStatus(remittanceRequest.getFromMembershipId());

        if(membershipStatus.equals(MembershipStatus.VALID)) {
            remittanceRequest.setRemittanceType(RemittanceType.RT0001);

            int remittanceResult1;
            int remittanceResult2;

            remittanceResult1 = memberMoneyPort.requestMemberMoneySend(remittanceRequest.getFromMembershipId(), remittanceRequest.getAmount());
            remittanceResult2 = memberMoneyPort.requestMemberMoneyReceive(remittanceRequest.getToMembershipId(), remittanceRequest.getAmount());

            if(remittanceResult1 == 1) {
                remittanceRequest.setRemittanceRequestStatus(RemittanceRequestStatus.INSUFFICIENT_BALANCE);
            } else if(remittanceResult1 == 2) {
                remittanceRequest.setRemittanceRequestStatus(RemittanceRequestStatus.MONEY_NOT_EXIST);
            }

            if(remittanceResult2 == 2) {
                remittanceRequest.setRemittanceRequestStatus(RemittanceRequestStatus.MONEY_NOT_EXIST);
            }
        } else if(membershipStatus.equals(MembershipStatus.NOT_EXIST)) {
            remittanceRequest.setRemittanceRequestStatus(RemittanceRequestStatus.MEMBER_NOT_EXIST);
            requestRemittancePort.createRemittanceRequestHistory(remittanceRequest);
            return remittanceRequest;
        }

        remittanceRequest.setRemittanceRequestStatus(RemittanceRequestStatus.COMPLETE);
        RemittanceRequestJpaEntity history = requestRemittancePort.createRemittanceRequestHistory(remittanceRequest);

        return remittanceRequest;
    }
}
