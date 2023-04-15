package com.aan.examencliniqueamani.Repository;

import com.aan.examencliniqueamani.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Long> {
}
