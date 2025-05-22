package com.az9s.hopital.Backend.utils.http.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String phone;
    private LocalDateTime loginedDate = LocalDateTime.now();

    public LoginResponse(String token, String phone) {
        this.phone = phone;
        this.token = token;
    }
}
