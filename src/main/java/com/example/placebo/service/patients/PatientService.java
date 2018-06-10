package com.example.placebo.service.patients;

import com.example.placebo.controllers.patient.CreatePatientRequest;
import com.example.placebo.controllers.patient.PatientResponse;
import com.example.placebo.controllers.patient.ShortPatientResponse;
import com.example.placebo.exceptions.ObjectNotFoundException;

import java.util.List;

public interface PatientService {

    List<ShortPatientResponse> getAllByTrialId(int id) throws ObjectNotFoundException;

    List<ShortPatientResponse> getByTrialIdAndPhase(int id, Integer phase);

    List<ShortPatientResponse> getByTrialIAndGroup(int id, Integer group) throws ObjectNotFoundException;

    List<ShortPatientResponse> getByTrialIdAndGroupAndPhase(int id, Integer group, Integer phase);

    PatientResponse add(CreatePatientRequest request) throws ObjectNotFoundException;

    PatientResponse getByPatientId(int id) throws ObjectNotFoundException;

}
