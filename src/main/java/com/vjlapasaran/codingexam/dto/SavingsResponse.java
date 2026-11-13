package com.vjlapasaran.codingexam.dto;

import java.math.BigDecimal;

public class SavingsResponse {

    private Long accountNumber;
    private String accountType;
    private BigDecimal availableBalance;

    public SavingsResponse(Long accountNumber, String accountType, BigDecimal availableBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.availableBalance = availableBalance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }
}
