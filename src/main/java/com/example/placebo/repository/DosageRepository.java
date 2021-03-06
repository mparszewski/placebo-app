package com.example.placebo.repository;


import com.example.placebo.entities.Dosage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DosageRepository extends JpaRepository<Dosage, Integer> {

    List<Dosage> findByPatient_Id(int patientId);
}
