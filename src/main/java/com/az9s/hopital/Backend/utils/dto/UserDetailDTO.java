package com.az9s.hopital.Backend.utils.dto;

import java.time.LocalDate;

import com.az9s.hopital.Backend.utils.option.GenderEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetailDTO {
    private String uniqueId;
    private String fullName;
    private LocalDate dateOfBirth;
    private GenderEnum gender;
    private String address;
    private String avatar;
}
