package com.example.placebo.service.dosages;

import com.example.placebo.controllers.dosage.CreateDosageRequest;
import com.example.placebo.controllers.dosage.DosageResponse;
import com.example.placebo.entities.Dosage;
import com.example.placebo.entities.Patient;
import com.example.placebo.exceptions.ObjectNotFoundException;
import com.example.placebo.repository.DosageRepository;
import com.example.placebo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DosageServiceImpl implements DosageService {

    private DosageRepository dosageRepository;
    private PatientRepository patientRepository;

    @Autowired
    public DosageServiceImpl(DosageRepository dosageRepository, PatientRepository patientRepository) {
        this.dosageRepository = dosageRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public DosageResponse add(CreateDosageRequest request) throws ObjectNotFoundException {
        Dosage dosage = createDosageFromRequest(request);
        dosageRepository.save(dosage);
        Patient patient = patientRepository.findById(request.getPatientId()).orElseThrow(ObjectNotFoundException::new);
        patient.setCurrentDosage(request.getDosage());
        patientRepository.save(patient);
        return new DosageResponse(dosage);
    }

    public Dosage createDosageFromRequest(CreateDosageRequest request) throws ObjectNotFoundException{
        Dosage dosage = new Dosage();
        LocalDateTime localDateTime = LocalDateTime.now();
        dosage.setDate(localDateTime);
        dosage.setDosage(request.getDosage());
        dosage.setPatient(patientRepository.findById(request.getPatientId()).orElseThrow(ObjectNotFoundException::new));
        return dosage;
    }
}
