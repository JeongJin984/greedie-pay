package com.greedie.pay.money.application.port.in;

public interface MemberMoneyUseCase {
     void chargeMemberMoney(ChargeMemberMoneyCommand command);
     void createMemberMoney(CreateMemberMoneyCommand command);

     void consumeMemberMoney(ConsumeMemberMoneyCommand command);
}
