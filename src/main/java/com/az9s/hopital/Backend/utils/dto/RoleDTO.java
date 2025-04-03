package com.az9s.hopital.Backend.utils.dto;

import java.util.List;

import com.az9s.hopital.Backend.entity.Permission;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDTO {
    private Long uniqueId = null;
    private String roleName = null;
    private List<Permission> permission = null;
}
