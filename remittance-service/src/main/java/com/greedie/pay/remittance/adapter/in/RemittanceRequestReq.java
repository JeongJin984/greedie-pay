package com.greedie.pay.remittance.adapter.in;

public record RemittanceRequestReq(
        String fromMembershipId,
        String toMembershipId,
        String toBankName,
        String toBankAccountNumber,
        String amount
) {
}
