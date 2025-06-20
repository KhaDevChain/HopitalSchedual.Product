package com.az9s.hopital.Backend.utils.http.request;

import com.az9s.hopital.Backend.utils.option.ActivateEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionRequest {
    private String uniqueId = null;
    private String groupName  = null;
    private String groupPermission = null;
    private ActivateEnum activated;
    private String description = null;
    private Long roleId = null;
}
