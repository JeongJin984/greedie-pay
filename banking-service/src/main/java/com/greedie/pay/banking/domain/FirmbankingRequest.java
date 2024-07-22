package com.greedie.pay.banking.domain;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FirmbankingRequest {
    private final UUID requestId;
    private final String fromBankName;
    private final String fromBankAccountNumber;
    private final String toBankName;
    private final String toBankAccountNumber;
    private final BigDecimal moneyAmount;
    @Enumerated(EnumType.STRING)
    private final FirmbankingRequestStatus firmbankingStatus;

    public static FirmbankingRequest generateFirmbankingRequest(
            UUID requestId,
            FromBankName fromBankName,
            FromBankAccountNumber fromBankAccountNumber,
            ToBankName toBankName,
            ToBankAccountNumber toBankAccountNumber,
            MoneyAmount moneyAmount,
            FirmbankingRequestStatus firmbankingRequestStatus
    ) {
        return new FirmbankingRequest(
                requestId,
                fromBankName.fromBankName(),
                fromBankAccountNumber.fromBankAccountNumber(),
                toBankName.toBankName(),
                toBankAccountNumber.toBankAccountNumber(),
                moneyAmount.moneyAmount(),
                firmbankingRequestStatus
        );
    }

    public record RequestId(String requestId) {}
    public record FromBankName(String fromBankName) {}
    public record FromBankAccountNumber(String fromBankAccountNumber) {}
    public record ToBankName(String toBankName) {}
    public record ToBankAccountNumber(String toBankAccountNumber) {}
    public record MoneyAmount(BigDecimal moneyAmount) {}

    @Getter
    public enum FirmbankingRequestStatus {
        REQUEST(0), COMPLETED(1), FAIL(2);
        private final int num;
        FirmbankingRequestStatus(int num) {
            this.num = num;
        }
        public static FirmbankingRequestStatus findByNum(int num) {
            return Arrays.stream(FirmbankingRequestStatus.values()).filter(v -> v.num == num).findFirst().orElseThrow(NoSuchElementException::new);
        }
    }
}
