package com.example.placebo.repository;

import com.example.placebo.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface DoctorsRepository extends JpaRepository<Doctor, Integer> {


}
