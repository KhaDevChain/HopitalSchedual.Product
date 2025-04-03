package com.az9s.hopital.Backend.utils.http.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String phone;
    private String password;
    private String email;
    private String fullName;
    private LocalDate dateOfBirth;
    private String address;
    private String avatar;
    private Long roleId;
}
