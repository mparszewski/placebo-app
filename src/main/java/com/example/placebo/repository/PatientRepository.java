package com.example.placebo.repository;

import com.example.placebo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByTrial_Id(int trialId);

    List<Patient> findByTrial_IdAndPhase(int trialId, Integer phase);

    List<Patient> findByTrial_IdAndGroup(int trialId, Integer group);

    List<Patient> findByTrial_IdAndGroupAndPhase(int id, Integer group, Integer phase);

}
