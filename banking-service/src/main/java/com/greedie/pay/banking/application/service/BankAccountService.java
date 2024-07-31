package com.greedie.pay.banking.application.service;

import com.greedie.pay.banking.application.port.in.RegisterBankAccountCommand;
import com.greedie.pay.banking.application.port.in.RegisterBankAccountUseCase;
import com.greedie.pay.banking.application.port.out.RegisterBankAccountPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountService implements RegisterBankAccountUseCase {
    private final RegisterBankAccountPersistencePort registerBankAccountPersistencePort;

    @Override
    public void registerBankAccount(RegisterBankAccountCommand command) {
        registerBankAccountPersistencePort.registerBankAccount(
                command.membershipId(),
                command.bankName(),
                command.bankAccountNumber(),
                true
        );

        
    }
}
