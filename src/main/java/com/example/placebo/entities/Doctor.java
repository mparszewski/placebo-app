package com.example.placebo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "doctor")
public class Doctor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "ssn")
    private long ssn;

    @Column(name = "specialisation")
    private String specialisation;

    @ManyToOne
    @JoinColumn(name = "trial_id")
    private Trial trial;
}
