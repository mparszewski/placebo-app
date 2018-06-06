package com.example.placebo.service.dosages;


import com.example.placebo.controllers.dosage.CreateDosageRequest;
import com.example.placebo.controllers.dosage.DosageResponse;
import com.example.placebo.exceptions.ObjectNotFoundException;

public interface DosageService {

    DosageResponse add(CreateDosageRequest request) throws ObjectNotFoundException;
}
