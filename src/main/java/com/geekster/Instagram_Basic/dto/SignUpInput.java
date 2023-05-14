package com.geekster.Instagram_Basic.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignUpInput {

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String firstName;

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String lastName;

    @NotBlank
    @Email
    private String emailId;

    @NotBlank
    @Pattern(regexp = "[A-Za-z\\D0-9]+")
    private String password;

}
