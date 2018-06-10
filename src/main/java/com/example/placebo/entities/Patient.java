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
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "ssn")
    private long ssn;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "phase")
    private int phase;

    @Column(name = "current_dosage")
    private String currentDosage;

    @Column(name = "placebo_group")
    private int placeboGroup;

    @ManyToOne
    @JoinColumn(name = "trial_id")
    private Trial trial;

    @OneToMany(mappedBy = "patient")
    List<Dosage> dosages = new ArrayList<>();

    @OneToMany(mappedBy = "patient")
    List<Observation> observations = new ArrayList<>();

}
