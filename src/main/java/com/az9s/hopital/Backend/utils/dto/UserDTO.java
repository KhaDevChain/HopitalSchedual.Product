package com.az9s.hopital.Backend.utils.dto;

import com.az9s.hopital.Backend.utils.option.ActivateEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private String uniqueId = null;
    private String phone = null;
    private String password = null;
    private String email = null;
    private String fullName = null;
    private ActivateEnum activated = null;
    private Long roleId = null;
    private String userRecordDetailId = null;
}
