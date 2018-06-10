package com.example.placebo.controllers.trials;


import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PasswordRequest {

    private String password;
    private int trialId;
}
