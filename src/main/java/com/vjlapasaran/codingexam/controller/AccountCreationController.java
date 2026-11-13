package com.vjlapasaran.codingexam.controller;

import com.vjlapasaran.codingexam.dto.CreateAccountRequest;
import com.vjlapasaran.codingexam.dto.CreateAccountResponse;
import com.vjlapasaran.codingexam.service.CustomerService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountCreationController {

    private final CustomerService customerService;

    public AccountCreationController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CreateAccountResponse> createAccount(
            @Valid @RequestBody CreateAccountRequest request) {

        CreateAccountResponse response = customerService.createCustomer(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
