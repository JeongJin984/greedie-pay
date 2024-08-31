package com.greedie.pay.remittance.domain.enums;

import lombok.Getter;

@Getter
public enum RemittanceType {
    RT0000("요청"),
    RT0001("멤버간 송금"),
    RT0002("해외 송금"),
    RT0003("타행 송금"),
    ;

    private final String remittanceName;

    RemittanceType(String remittanceName) {
        this.remittanceName = remittanceName;
    }


}
