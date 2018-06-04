package com.example.placebo.entities;

import lombok.*;

import javax.persistence.*;
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

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "description", length = 2048)
    private String description;

    @Column(name = "is_archived")
    private int isArchived;

    @OneToMany(mappedBy = "trial", cascade = CascadeType.ALL)
    private List<Doctor> doctors = new ArrayList<>();

}
