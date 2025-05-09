package com.ishemah.vehiclemanagementsystem.services;

import com.ishemah.vehiclemanagementsystem.models.PlateNumber;

import java.util.UUID;

public interface IPlateNumberService {
    PlateNumber generateAndAssignPlateNumberToOwner(UUID ownerId);
}
