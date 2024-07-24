package com.greedie.pay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberBankAccount {
    private final String bankAccountId;
    private final String membershipId;
    private final String bankName;
    private final String bankAccountNumber;
    private final Boolean isValid;

    public static MemberBankAccount generateBankAccount(
            RegisteredBankAccountId registeredBankAccountId,
            MembershipId membershipId,
            BankName bankName,
            BankAccountNumber bankAccountNumber,
            IsValid isValid
    ) {
        return new MemberBankAccount(
                registeredBankAccountId.registeredBankAccountId,
                membershipId.membershipId,
                bankName.bankName,
                bankAccountNumber.bankAccountNumber,
                isValid.isValid
        );
    }

    public record RegisteredBankAccountId (String registeredBankAccountId) {}
    public record MembershipId (String membershipId) {}
    public record BankName (String bankName) {}
    public record BankAccountNumber (String bankAccountNumber) {}
    public record IsValid(boolean isValid) {}
}
