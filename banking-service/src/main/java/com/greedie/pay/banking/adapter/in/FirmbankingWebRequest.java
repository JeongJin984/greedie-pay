package com.greedie.pay.banking.adapter.in;

public record FirmbankingWebRequest(
        String fromBankName,
        String fromBankAccountNumber,
        String toBankName,
        String toBankAccountNumber,
        int moneyAmount
) {
}
