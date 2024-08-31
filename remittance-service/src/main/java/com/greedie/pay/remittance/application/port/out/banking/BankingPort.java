package com.greedie.pay.remittance.application.port.out.banking;

import java.math.BigDecimal;

public interface BankingPort {
    boolean requestFirmbanking(String bankName, String bankAccountNumber, BigDecimal amount);
}
