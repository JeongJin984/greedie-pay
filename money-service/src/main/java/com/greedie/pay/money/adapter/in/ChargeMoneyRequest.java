package com.greedie.pay.money.adapter.in;

public record ChargeMoneyRequest (
        String membershipId,
        String amount,
        String currency
) {
}
