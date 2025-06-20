package com.az9s.hopital.Backend.utils.http.response;

import java.time.LocalDateTime;

import com.az9s.hopital.Backend.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private User user;
    private LocalDateTime loginedDate = LocalDateTime.now();

    public LoginResponse(String token, User user) {
        this.user = user;
        this.token = token;
        this.loginedDate = LocalDateTime.now();
    }
}
