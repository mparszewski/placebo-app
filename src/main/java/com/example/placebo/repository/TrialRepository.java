package com.example.placebo.repository;

import com.example.placebo.entities.Trial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrialRepository extends JpaRepository<Trial, Integer> {

    List<Trial> findByIsArchived(int isArchived);
}
