package com.geekster.Instagram_Basic.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String userFirstName;

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String userLastName;

    @Nullable
    @Min(value = 18L,message = "Age can not be less than 18")
    @Max(value = 100L,message = "Age can not be greater than 100")
    private Integer userAge;

    @NotBlank
    @Email
    @Column(unique = true)
    private String userEmail;

    @NotBlank
    @Pattern(regexp = "[A-Za-z\\D0-9]+")
    private String userPassword;

    @Nullable
    @Pattern(regexp = "[0-9]{10,12}")
    private String userPhNumber;

    public User(String firstName, String lastName, String emailId, String encryptedPassword) {
        this.userFirstName=firstName;
        this.userLastName=lastName;
        this.userEmail=emailId;
        this.userPassword=encryptedPassword;
    }
}
