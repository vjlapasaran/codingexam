package com.vjlapasaran.codingexam.service;

import com.vjlapasaran.codingexam.dto.CreateAccountRequest;
import com.vjlapasaran.codingexam.dto.CreateAccountResponse;
import com.vjlapasaran.codingexam.entity.CustomerEntity;
import com.vjlapasaran.codingexam.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CreateAccountResponse createCustomer(CreateAccountRequest request) {

        CustomerEntity customer = new CustomerEntity();

        customer.setCustomerName(request.getCustomerName());
        customer.setCustomerMobile(request.getCustomerMobile());
        customer.setCustomerEmail(request.getCustomerEmail());
        customer.setAddress1(request.getAddress1());
        customer.setAddress2(request.getAddress2());
        customer.setAccountType(request.getAccountType());

        CustomerEntity savedCustomer = customerRepository.save(customer);

        return new CreateAccountResponse(
                String.format("%08d", 12345677L + savedCustomer.getCustomerId()),
                String.valueOf(HttpStatus.CREATED.value()),
                "Customer account Created!"
        );
    }
}
