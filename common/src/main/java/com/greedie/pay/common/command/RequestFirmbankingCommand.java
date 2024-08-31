package com.greedie.pay.common.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestFirmbankingCommand {
    private String firmbankingRequestId;
    private String rechargeRequestId;
    private String membershipId;
    private String fromBankName;
    private String fromBankAccountNumber;
    private String toBankName;
    private String toBankAccountNumber;
    private String moneyAmount; // only won
}