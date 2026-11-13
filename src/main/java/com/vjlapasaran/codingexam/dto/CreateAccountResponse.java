package com.vjlapasaran.codingexam.dto;

import lombok.Getter;

@Getter
public class CreateAccountResponse {

    private final String customerNumber;
    private final String transactionStatusCode;
    private final String transactionStatusDescription;

    public CreateAccountResponse(
            String customerNumber,
            String transactionStatusCode,
            String transactionStatusDescription
    ) {
        this.customerNumber = customerNumber;
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }

}
