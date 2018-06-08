package com.example.placebo.service.dosages;


import com.example.placebo.controllers.dosage.CreateDosageRequest;
import com.example.placebo.controllers.dosage.DosageResponse;
import com.example.placebo.exceptions.ObjectNotFoundException;

import java.util.List;

public interface DosageService {

    DosageResponse add(CreateDosageRequest request) throws ObjectNotFoundException;

    List<DosageResponse> getByPatientId(int id) throws ObjectNotFoundException;
}
