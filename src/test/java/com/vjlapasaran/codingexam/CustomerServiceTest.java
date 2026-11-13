package com.vjlapasaran.codingexam;


import com.vjlapasaran.codingexam.dto.CreateAccountRequest;
import com.vjlapasaran.codingexam.dto.CreateAccountResponse;
import com.vjlapasaran.codingexam.entity.CustomerEntity;
import com.vjlapasaran.codingexam.repository.CustomerRepository;
import com.vjlapasaran.codingexam.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void shouldCreateCustomerSuccessfully() {

        CreateAccountRequest request = new CreateAccountRequest();

        request.setCustomerName("Test");
        request.setCustomerMobile("09081234567");
        request.setCustomerEmail("test12345@gmail.com");
        request.setAddress1("Test Address");
        request.setAddress2("Test Address 2");
        request.setAccountType("SAVINGS");

        CustomerEntity savedCustomer = new CustomerEntity();
        savedCustomer.setCustomerId(1L);
        savedCustomer.setCustomerName("Test");
        savedCustomer.setCustomerMobile("09081234567");
        savedCustomer.setCustomerEmail("test12345@gmail.com");
        savedCustomer.setAddress1("Test Address");
        savedCustomer.setAddress2("Test Address 2");
        savedCustomer.setAccountType("SAVINGS");

        when(customerRepository.save(any(CustomerEntity.class)))
                .thenReturn(savedCustomer);

        CreateAccountResponse response =
                customerService.createCustomer(request);

        assertEquals("12345678", response.getCustomerNumber());
        assertEquals("201", response.getTransactionStatusCode());
        assertEquals("Customer account Created!",
                response.getTransactionStatusDescription());

        verify(customerRepository, times(1))
                .save(any(CustomerEntity.class));
    }
}
