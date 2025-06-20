package com.az9s.hopital.Backend.utils.http.response;

import java.util.HashMap;
import java.util.List;

import com.az9s.hopital.Backend.entity.Permission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionResponse {
    private String message;
    private Permission permission;
    private List<Permission> permissions;
    private HashMap<String, HashMap<String, String>> groupedPermissions;
}
