package com.ishemah.vehiclemanagementsystem.dtos.request.user;


import com.ishemah.vehiclemanagementsystem.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {
    private User user;
}