package com.example.placebo.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "trial")
public class Trial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "study_title")
    private String studyTitle;

    @Column(name = "phase")
    private int phase;

    @Column(name = "is_archived")
    private int isArchived;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "masking")
    private String masking;

    @Column(name = "responsible_party")
    private String responsibleParty;

    @Column(name = "study_description")
    private String studyDescription;

    @Column(name = "treatment_description")
    private String treatmentDescription;

    @Column(name = "eligibilty_criterias")
    private String eligibiltyCriterias;

    @Column(name = "estimated_end_date")
    private LocalDate estimatedEndDate;

    @Column(name = "contacts_and_locations")
    private String contactsAndLocations;

    @OneToMany(mappedBy = "trial", cascade = CascadeType.ALL)
    private List<Doctor> doctors = new ArrayList<>();

    @OneToMany(mappedBy = "trial")
    private List<Patient> patients = new ArrayList<>();

}
