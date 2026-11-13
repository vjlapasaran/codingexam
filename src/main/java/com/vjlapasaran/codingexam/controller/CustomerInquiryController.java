package com.vjlapasaran.codingexam.controller;

import com.vjlapasaran.codingexam.dto.CustomerInquiryResponse;
import com.vjlapasaran.codingexam.service.CustomerInquiryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerInquiryController {

    private final CustomerInquiryService customerInquiryService;

    public CustomerInquiryController(CustomerInquiryService customerInquiryService) {
        this.customerInquiryService = customerInquiryService;
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<CustomerInquiryResponse> getCustomer(
            @PathVariable String customerNumber) {

        CustomerInquiryResponse response = customerInquiryService.getCustomerByNumber(customerNumber);

        return ResponseEntity.ok(response);
    }
}
