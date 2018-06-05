package com.example.placebo.repository;

import com.example.placebo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByTrial_Id(int trialId);

    List<Patient> findByTrial_IdAndIsPlaceboAndPhase(int id, int isPlacebo, int phase);
}
