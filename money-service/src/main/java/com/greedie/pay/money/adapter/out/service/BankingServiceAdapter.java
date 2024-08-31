package com.greedie.pay.money.adapter.out.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greedie.pay.common.CommonHttpClient;
import com.greedie.pay.money.application.port.out.GetRegisteredBankAccount;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BankingServiceAdapter implements GetRegisteredBankAccount {
    private final CommonHttpClient commonHttpClient;
    private final String bankingServiceUrl;

    public BankingServiceAdapter(
            CommonHttpClient commonHttpClient,
            @Value("${service.banking.url}") String bankingServiceUrl
    ) {
        this.commonHttpClient = commonHttpClient;
        this.bankingServiceUrl = bankingServiceUrl;
    }

    @Override
    public RegisteredBankAccount getRegisteredBankAccount(String membershipId) {
        String url = String.join("/", bankingServiceUrl, "banking/account", membershipId);
        try {
            String jsonResponse = commonHttpClient.sendGetRequest(url).body();

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonResponse, RegisteredBankAccount.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


