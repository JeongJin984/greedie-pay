package com.greedie.pay.banking.application.port.out;

public interface RegisterBankAccountPersistencePort {
    void registerBankAccount(String membershipId, String bankName, String bankAccountNumber, Boolean isValid);
}
