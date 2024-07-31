package com.greedie.pay.banking.application.port.in;

public record RegisterBankAccountCommand (
        String membershipId,
        String bankName,
        String bankAccountNumber
) {
}
