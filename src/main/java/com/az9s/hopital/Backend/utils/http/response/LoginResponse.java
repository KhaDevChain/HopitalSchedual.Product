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
    private String email;
    private LocalDateTime loginedDate = LocalDateTime.now();

    public LoginResponse(String token, String phone, String email) {
        this.phone = phone;
        this.token = token;
        this.email = email;
    }
}
