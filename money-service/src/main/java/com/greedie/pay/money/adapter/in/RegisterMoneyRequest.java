package com.greedie.pay.money.adapter.in;

public record RegisterMoneyRequest (
        String ownerMembershipId,
        String currency,
        String money
) {
}
