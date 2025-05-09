package com.ishemah.vehiclemanagementsystem.services.impl;

import com.ishemah.vehiclemanagementsystem.enums.EPlateStatus;
import com.ishemah.vehiclemanagementsystem.exceptions.NotFoundException;
import com.ishemah.vehiclemanagementsystem.models.Owner;
import com.ishemah.vehiclemanagementsystem.models.PlateNumber;
import com.ishemah.vehiclemanagementsystem.repositories.IOwnerRepository;
import com.ishemah.vehiclemanagementsystem.repositories.IPlateNumberRepository;
import com.ishemah.vehiclemanagementsystem.services.IPlateNumberService;
import com.ishemah.vehiclemanagementsystem.utils.helpers.PlateNumberGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlateNumberServiceImpl implements IPlateNumberService {

    private final IPlateNumberRepository plateNumberRepository;
    private final IOwnerRepository ownerRepository;
    private final PlateNumberGenerator plateNumberGenerator;

    @Override
    @Transactional
    public PlateNumber generateAndAssignPlateNumberToOwner(UUID ownerId) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new NotFoundException("Owner not found with ID: " + ownerId));

        String plateValue = plateNumberGenerator.generateNextPlateNumber();

        PlateNumber plateNumber = PlateNumber.builder()
                .owner(owner)
                .plateNumber(plateValue)
                .plateStatus(EPlateStatus.AVAILABLE)
                .issuedDate(LocalDateTime.now())
                .build();

        return plateNumberRepository.save(plateNumber);
    }
}
