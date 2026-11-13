package com.vjlapasaran.codingexam.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateAccountRequest {

    @NotBlank(message = "Customer name is required!")
    private String customerName;

    @NotBlank(message = "Customer mobile is required!")
    private String customerMobile;

    @NotBlank(message = "Customer email is required!")
    @Email(message = "Invalid Email Fields!")
    private String customerEmail;

    @NotBlank(message = "Address 1 field required!")
    private String address1;

    private String address2;

    @NotNull(message = "Account type field is required!")
    @Pattern(regexp = "SAVINGS|CHECKING",message = "Account type must be SAVINGS or CHECKING")
    private String accountType;
}
