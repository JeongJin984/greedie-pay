package com.greedie.pay.money.application.port.out;

import com.greedie.pay.money.adapter.out.service.RegisteredBankAccount;

public interface GetRegisteredBankAccount {
    RegisteredBankAccount getRegisteredBankAccount(String membershipId);
}
