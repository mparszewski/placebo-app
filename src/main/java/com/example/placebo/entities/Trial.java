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
    private int masking;

    @Column(name = "responsible_party")
    private String responsibleParty;

    @Column(name = "study_description", length = 2048)
    private String studyDescription;

    @Column(name = "treatment_description", length = 2048)
    private String treatmentDescription;

    @Column(name = "eligibilty_criterias", length = 2048)
    private String eligibiltyCriterias;

    @Column(name = "estimated_end_date")
    private LocalDate estimatedEndDate;

    @Column(name = "contacts_and_locations", length = 2048)
    private String contactsAndLocations;

    @Column(name = "password")
    private String password;

    @Column(name = "is_placebo_reversed")
    private int isPlaceboReversed;

    @OneToMany(mappedBy = "trial", cascade = CascadeType.ALL)
    private List<Doctor> doctors = new ArrayList<>();

    @OneToMany(mappedBy = "trial")
    private List<Patient> patients = new ArrayList<>();

}
