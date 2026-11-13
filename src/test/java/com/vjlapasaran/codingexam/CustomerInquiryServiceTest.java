package com.vjlapasaran.codingexam;

import java.util.Optional;

import com.vjlapasaran.codingexam.dto.CustomerInquiryResponse;
import com.vjlapasaran.codingexam.service.CustomerInquiryService;
import com.vjlapasaran.codingexam.entity.CustomerEntity;
import com.vjlapasaran.codingexam.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verifyNoInteractions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CustomerInquiryServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerInquiryService customerInquiryService;

    @Test
    void shouldReturnCustomerSuccessfully() {

        CustomerEntity customer = new CustomerEntity();
        customer.setCustomerId(1L);
        customer.setCustomerName("Test");
        customer.setCustomerMobile("09081234567");
        customer.setCustomerEmail("test12345@gmail.com");
        customer.setAddress1("Test Address");
        customer.setAddress2("Test Address 2");
        customer.setAccountType("SAVINGS");

        when(customerRepository.findByCustomerId(1L))
                .thenReturn(Optional.of(customer));

        CustomerInquiryResponse response =
                customerInquiryService.getCustomerByNumber("12345678");

        assertEquals("12345678", response.getCustomerNumber());
        assertEquals("Test", response.getCustomerName());
        assertEquals("09081234567", response.getCustomerMobile());
        assertEquals("test12345@gmail.com", response.getCustomerEmail());
        assertEquals(302, response.getTransactionStatusCode());
        assertEquals("Customer Account found",
                response.getTransactionStatusDescription());

        assertEquals(1, response.getSavings().size());
        assertEquals(10001L,
                response.getSavings().get(0).getAccountNumber());

        verify(customerRepository, times(1))
                .findByCustomerId(1L);
    }

    @Test
    void shouldThrowBadRequestForInvalidCustomerNumber() {

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> customerInquiryService.getCustomerByNumber("ABC")
        );

        assertEquals(400, exception.getStatusCode().value());

        verifyNoInteractions(customerRepository);
    }

    @Test
    void shouldThrowNotFoundWhenCustomerDoesNotExist() {

        when(customerRepository.findByCustomerId(87654322L))
                .thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> customerInquiryService.getCustomerByNumber("99999999")
        );

        assertEquals(404, exception.getStatusCode().value());

        verify(customerRepository, times(1))
                .findByCustomerId(87654322L);
    }
}