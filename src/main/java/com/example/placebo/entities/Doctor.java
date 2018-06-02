package com.example.placebo.entities;


import lombok.*;

import javax.persistence.*;


@Entity
//@Table(name = "doctor")
public class Doctor{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //@Column(name = "firstName")
    private String firstName;

    //@Column(name = "lastName")
    private String lastName;

    //@Column(name = "ssn")
    private int ssn;

    //@Column(name = "specialization")
    private String specialization;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Doctor(String firstName, String lastName, int ssn, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.specialization = specialization;
    }

    public Doctor() {
        super();
    }
}
