package com.az9s.hopital.Backend.utils.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Long uniqueId = null;
    private String roleName = null;
    private LocalDateTime createdAt = null;
    private PermissionDTO permissionDTO = null;
}
