package com.example.placebo.service;

import com.example.placebo.controllers.DoctorResponse;
import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;

import java.util.List;

public interface DoctorService {

    List<DoctorResponse> findAll();

    DoctorResponse findById(int id) throws ObjectAlreadyActive;
}
