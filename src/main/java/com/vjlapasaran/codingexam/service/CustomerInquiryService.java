package com.vjlapasaran.codingexam.service;

import com.vjlapasaran.codingexam.dto.CustomerInquiryResponse;
import com.vjlapasaran.codingexam.dto.SavingsResponse;
import com.vjlapasaran.codingexam.entity.CustomerEntity;
import com.vjlapasaran.codingexam.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerInquiryService {

    private final CustomerRepository customerRepository;

    public CustomerInquiryService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerInquiryResponse getCustomerByNumber(String customerNumber) {

        //Validation
        if(customerNumber == null || !customerNumber.matches("\\d{8}")) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Invalid customer number"
            );
        }
        //Convert the customer number into generated Database ID
        Long customerId = Long.parseLong(customerNumber) - 12345677L;

        CustomerEntity customer = customerRepository
                .findByCustomerId(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer not found"));

        //Response
        CustomerInquiryResponse response = new CustomerInquiryResponse();

        response.setCustomerNumber(customerNumber);
        response.setCustomerName(customer.getCustomerName());
        response.setCustomerMobile(customer.getCustomerMobile());
        response.setCustomerEmail(customer.getCustomerEmail());
        response.setAddress1(customer.getAddress1());
        response.setAddress2(customer.getAddress2());
        response.setAccountType(customer.getAccountType());

        SavingsResponse savings = new SavingsResponse(
                10001L,
                "Savings",
                new BigDecimal("500.00")
        );

        response.setSavings(List.of(savings));

        response.setTransactionStatusCode(HttpStatus.FOUND.value());
        response.setTransactionStatusDescription("Customer Account found");

        return response;
    }
}
