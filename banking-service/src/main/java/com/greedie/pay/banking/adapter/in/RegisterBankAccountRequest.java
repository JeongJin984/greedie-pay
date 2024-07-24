package com.greedie.pay.banking.adapter.in;

public record RegisterBankAccountRequest (
        String membershipId,
        String bankName,
        String bankAccountNumber,
        boolean isValid
) {
}
