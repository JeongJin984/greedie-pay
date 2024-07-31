package com.greedie.pay.banking.adapter.in;

import com.greedie.pay.banking.application.port.in.RegisterBankAccountCommand;
import com.greedie.pay.banking.application.port.in.RegisterBankAccountUseCase;
import com.greedie.pay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RequiredArgsConstructor
@RestController("/api/v1/bankAccount")
public class BankAccountController {
    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping("/register")
    public void registerBankAccount(
            @RequestBody RegisterBankAccountRequest body
    ) {
        RegisterBankAccountCommand command = new RegisterBankAccountCommand(
                body.membershipId(),
                body.bankName(),
                body.bankAccountNumber()
        );

        registerBankAccountUseCase.registerBankAccount(command);
    }

}
