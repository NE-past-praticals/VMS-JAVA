package com.ishemah.vehiclemanagementsystem.services;


import com.ishemah.vehiclemanagementsystem.dtos.request.role.CreateRoleDTO;
import com.ishemah.vehiclemanagementsystem.dtos.response.role.RoleResponseDTO;
import com.ishemah.vehiclemanagementsystem.dtos.response.role.RolesResponseDTO;
import com.ishemah.vehiclemanagementsystem.enums.ERole;
import com.ishemah.vehiclemanagementsystem.models.Role;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IRoleService {
    public Role getRoleById(UUID roleId);

    public Role getRoleByName(ERole roleName);

    public void createRole(ERole roleName);

    public RoleResponseDTO createRole(CreateRoleDTO createRoleDTO);

    public RolesResponseDTO getRoles(Pageable pageable);

    public void deleteRole(UUID roleId);

    public boolean isRolePresent(ERole roleName);
}