package com.example.placebo.controllers.patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CreatePatientRequest {

    private String name;
    private String surname;
    private long ssn;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private int trialId;

}
