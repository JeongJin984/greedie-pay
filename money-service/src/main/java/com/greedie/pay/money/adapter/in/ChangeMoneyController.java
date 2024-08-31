package com.greedie.pay.money.adapter.in;

import com.greedie.pay.money.application.port.in.ChargeMemberMoneyCommand;
import com.greedie.pay.money.application.port.in.CreateMemberMoneyCommand;
import com.greedie.pay.money.application.port.in.MemberMoneyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/money/change")
@RequiredArgsConstructor
public class ChangeMoneyController {
    private final MemberMoneyUseCase memberMoneyUseCase;

    @PostMapping("/register")
    public ResponseEntity<Object> registerMoney(
            @RequestBody RegisterMoneyRequest registerMoneyRequest
    ) {
        memberMoneyUseCase.createMemberMoney(new CreateMemberMoneyCommand(
                registerMoneyRequest.ownerMembershipId(),
                registerMoneyRequest.money(),
                new BigDecimal(registerMoneyRequest.money())
        ));

        return ResponseEntity.ok().build();
    }

    @PostMapping("/charge")
    public ResponseEntity<Object> chargeMoney(
            @RequestBody ChargeMoneyRequest chargeMoneyRequest
    ) {
        new ChargeMemberMoneyCommand(
                chargeMoneyRequest.membershipId(),
                chargeMoneyRequest.currency(),
                new BigDecimal(chargeMoneyRequest.amount())
        );
    }
}
