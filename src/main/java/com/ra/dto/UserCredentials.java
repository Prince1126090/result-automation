package com.ra.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserCredentials {
    @NotBlank
    private String contactNumber;
    @NotBlank
    private String password;
}
