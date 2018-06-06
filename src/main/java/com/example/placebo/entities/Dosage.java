package com.example.placebo.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "dosage")
public class Dosage {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "dosage")
    private String dosage;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
