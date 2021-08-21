package com.digitalexperts.authService.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomError {
    private String errorMessage;
    private String requestPath;
    private String timestamp;
}
