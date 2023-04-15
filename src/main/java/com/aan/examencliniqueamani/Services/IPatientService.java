package com.aan.examencliniqueamani.Services;

import com.aan.examencliniqueamani.Entity.Patient;
import com.aan.examencliniqueamani.Repository.PatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class IPatientService implements ServicePatient{
    private final PatientRepo patientRepo ;
    @Override
    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }
}
