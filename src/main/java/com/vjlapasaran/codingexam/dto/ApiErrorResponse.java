package com.vjlapasaran.codingexam.dto;

public class ApiErrorResponse {

    private int transactionStatusCode;
    private String transactionStatusDescription;

    public ApiErrorResponse(int transactionStatusCode, String transactionStatusDescription) {
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }

    public int getTransactionStatusCode() {
        return transactionStatusCode;
    }

    public String getTransactionStatusDescription() {
        return transactionStatusDescription;
    }
}
