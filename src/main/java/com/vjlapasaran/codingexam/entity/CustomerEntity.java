package com.vjlapasaran.codingexam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_mobile", nullable = false)
    private String customerMobile;

    @Column(name = "customer_email", nullable = false, unique = true)
    private String customerEmail;

    @Column(name = "address1", nullable = false)
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "account_type", nullable = false)
    private String AccountType;

}
