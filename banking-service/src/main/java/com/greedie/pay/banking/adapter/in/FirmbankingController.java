package com.greedie.pay.banking.adapter.in;

import com.greedie.pay.banking.application.port.in.FirmbankingRequestCommand;
import com.greedie.pay.banking.application.port.in.FirmbankingRequestUseCase;
import com.greedie.pay.banking.domain.FirmbankingRequest;
import com.greedie.pay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@WebAdapter
@RequiredArgsConstructor
@RestController("/api/v1/banking")
public class FirmbankingController {
    private final FirmbankingRequestUseCase firmbankingRequestUseCase;

    @PostMapping("/firmbanking/request")
    public ResponseEntity<Object> firmbankingRequest(
            @RequestBody FirmbankingWebRequest webRequest
    ) {
        FirmbankingRequest firmbankingRequest = firmbankingRequestUseCase.requestFirmbankingCheckAccount(new FirmbankingRequestCommand(
                webRequest.fromBankName(),
                webRequest.fromBankAccountNumber(),
                webRequest.toBankName(),
                webRequest.toBankAccountNumber(),
                new BigDecimal(webRequest.moneyAmount())
        ));

        return ResponseEntity.ok(firmbankingRequest.getFirmbankingStatus());
    }
}
