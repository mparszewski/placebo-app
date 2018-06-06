package com.example.placebo.repository;


import com.example.placebo.entities.Dosage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DosageRepository extends JpaRepository<Dosage, Integer> {
}
