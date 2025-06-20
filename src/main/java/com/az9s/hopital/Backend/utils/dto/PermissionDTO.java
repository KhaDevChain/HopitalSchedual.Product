package com.az9s.hopital.Backend.utils.dto;

import java.util.List;

import com.az9s.hopital.Backend.utils.option.ActivateEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionDTO {
    private String uniqueId = null;
    private String groupName  = null;
    private String groupPermission = null;
    private ActivateEnum activated;
    private String description = null;
    private Long roleId = null;
    private String roleName = null;
    private List<PermissionDTO> permissionDTOs = null;
}
