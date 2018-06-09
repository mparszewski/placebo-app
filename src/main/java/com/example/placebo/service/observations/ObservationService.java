package com.example.placebo.service.observations;

import com.example.placebo.controllers.observations.CreateObservationRequest;
import com.example.placebo.controllers.observations.ObservationResponse;
import com.example.placebo.controllers.observations.ShortObservationResponse;
import com.example.placebo.exceptions.ObjectNotFoundException;

import java.util.List;

public interface ObservationService {

    ObservationResponse add(CreateObservationRequest request) throws ObjectNotFoundException;

    ObservationResponse getObservationById(int observationId) throws ObjectNotFoundException;

    List<ObservationResponse> getObservationsByPatientId(int patientId);
}
