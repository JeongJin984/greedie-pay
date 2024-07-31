package com.greedie.pay.banking.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "member_bank_account")
@NoArgsConstructor
public class MemberBankAccountJPAEntity {
    @Id
    private String registeredBankAccountId;
    private String membershipId;
    private String bankName;
    private String bankAccountNumber;
    private Boolean isValid;

    public MemberBankAccountJPAEntity(String membershipId, String bankName, String bankAccountNumber, Boolean isValid) {
        this.registeredBankAccountId = UUID.randomUUID().toString();
        this.membershipId = membershipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.isValid = isValid;
    }
}
