package com.vjlapasaran.codingexam.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerInquiryResponse {

    private String customerNumber;
    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;
    private String accountType;

    private List<SavingsResponse> savings;
    private int transactionStatusCode;
    private String transactionStatusDescription;

    public CustomerInquiryResponse() {

    }
}
