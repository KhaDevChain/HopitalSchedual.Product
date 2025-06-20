package com.az9s.hopital.Backend.api;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az9s.hopital.Backend.entity.Permission;
import com.az9s.hopital.Backend.entity.Role;
import com.az9s.hopital.Backend.service.PermissionService;
import com.az9s.hopital.Backend.service.RoleService;
import com.az9s.hopital.Backend.utils.group.PermissionGroup;
import com.az9s.hopital.Backend.utils.http.request.PermissionRequest;
import com.az9s.hopital.Backend.utils.http.response.PermissionResponse;
import com.az9s.hopital.Backend.utils.option.ActivateEnum;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/permissions")
public class PermissionRestController {
    @Autowired
    @Qualifier("cachePermissionService")
    private PermissionService permissionService;

    @Autowired
    @Qualifier("cacheRoleService")
    private RoleService roleService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(
            new PermissionResponse("Permissions retrieved successfully", null, permissionService.findAll(), null)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPermissions() {
        return ResponseEntity.ok(
            new PermissionResponse("Permissions retrieved successfully", null, null, PermissionGroup.permissions)
        );
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PermissionRequest permissionRequest) {
        Permission permissionSaved = permissionService.savePermission(
            asignNewPermission(permissionRequest)
        );
        return ResponseEntity.ok(
            new PermissionResponse("Permission saved successfully", permissionSaved, null, null)
        );
    }
    

    /**
     * asign permission create
     * @param hopitalRequest
     * @return
     */
    public Permission asignNewPermission(PermissionRequest permissionRequest) {
        Permission permission = null;
        if (permissionRequest != null) {
            Role role = roleService.findById(permissionRequest.getRoleId());
            permission = new Permission();
            permission.setUniqueId(UUID.randomUUID().toString());
            permission.setGroupName(permissionRequest.getGroupName());
            permission.setGroupPermission(permissionRequest.getGroupPermission());
            permission.setCreatedAt(LocalDateTime.now());
            permission.setActivated(ActivateEnum.ACTIVE);
            permission.setDescription(permissionRequest.getDescription());
            permission.setRole(role);
        }
        return permission;
    }
}
