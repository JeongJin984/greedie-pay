package com.greedie.pay.remittance.application.port.out.money;

import java.math.BigDecimal;

public interface MemberMoneyPort {
     int requestMemberMoneySend(String membershipId, BigDecimal amount);
     int requestMemberMoneyReceive(String membershipId, BigDecimal amount);
}
