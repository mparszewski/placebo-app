package com.example.placebo.repository;

import com.example.placebo.entities.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, Integer> {

    List<Observation> findByPatient_Id(int id);
}
