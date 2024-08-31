package com.greedie.pay.remittance.domain.enums;

import lombok.Getter;

@Getter
public enum RemittanceRequestStatus {
    REQUEST,
    COMPLETE,
    INSUFFICIENT_BALANCE,
    MEMBER_NOT_AVAILABLE,
    MEMBER_NOT_EXIST,
    CHARGE_FAILED,
    MONEY_NOT_EXIST
}
