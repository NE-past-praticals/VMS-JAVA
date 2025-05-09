package com.ishemah.vehiclemanagementsystem.dtos.request.role;


import com.ishemah.vehiclemanagementsystem.enums.ERole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateRoleDTO {
    @Schema(example = "ADMIN", description = "Role name")
    private ERole name;
}
