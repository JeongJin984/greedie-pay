package com.greedie.pay.remittance.adapter.out.service.banking;

import com.greedie.pay.remittance.application.port.out.banking.BankingPort;

import java.math.BigDecimal;

public class BankServiceAdapter implements BankingPort {
    @Override
    public boolean requestFirmbanking(String bankName, String bankAccountNumber, BigDecimal amount) {
        return false;
    }
}
