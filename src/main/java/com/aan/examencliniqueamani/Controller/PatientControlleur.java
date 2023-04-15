package com.aan.examencliniqueamani.Controller;

import com.aan.examencliniqueamani.Entity.Patient;
import com.aan.examencliniqueamani.Services.ServicePatient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/patient")
public class PatientControlleur {

    private final ServicePatient servicePatient;

@PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient){
        return servicePatient.addPatient(patient);
    }
}
