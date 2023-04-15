package com.aan.examencliniqueamani.Repository;

import com.aan.examencliniqueamani.Entity.Clinique;
import com.aan.examencliniqueamani.Entity.Medecin;
import com.aan.examencliniqueamani.Entity.RendezVous;
import com.aan.examencliniqueamani.Entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
import java.util.Set;

public interface RendezVousRepo extends JpaRepository<RendezVous,Long> {
    Set<RendezVous> findByMedecinSpecialiteAndMedecinCliniques(Specialite specialite, Clinique clinique);
    //Set<RendezVous> findRendezVousByDateRDVDayBefore(Date date);
    Set<RendezVous> findByDateRDVGreaterThan(Date date);
    Set<RendezVous> findByMedecinAndDateRDVAfterAndDateRDVBefore(Medecin medecin,Date start,Date end);
}
