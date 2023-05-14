package com.geekster.Instagram_Basic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpOutput {

    private String message;

    private HttpStatus statusCode;

}
