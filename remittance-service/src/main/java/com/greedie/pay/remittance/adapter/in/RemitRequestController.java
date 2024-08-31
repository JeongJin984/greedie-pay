package com.greedie.pay.remittance.adapter.in;

import com.greedie.pay.remittance.domain.RemittanceRequest;
import com.greedie.pay.remittance.domain.enums.RemittanceRequestStatus;
import com.greedie.pay.remittance.domain.enums.RemittanceType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/remittance")
public class RemitRequestController {

    @PostMapping("/remit")
    public void remitRequest(
            @RequestBody RemittanceRequestReq remittanceRequestReq
    ) {
        RemittanceRequest remittanceRequest = new RemittanceRequest(
                remittanceRequestReq.fromMembershipId(),
                remittanceRequestReq.toMembershipId(),
                remittanceRequestReq.toBankName(),
                remittanceRequestReq.toBankAccountNumber(),
                RemittanceType.RT0000,
                RemittanceRequestStatus.REQUEST,
                new BigDecimal(remittanceRequestReq.amount())
        );
    }
}
