package com.aan.examencliniqueamani.Services;

import com.aan.examencliniqueamani.Entity.*;
import com.aan.examencliniqueamani.Repository.CliniqueRepo;
import com.aan.examencliniqueamani.Repository.MedecinRepo;
import com.aan.examencliniqueamani.Repository.PatientRepo;
import com.aan.examencliniqueamani.Repository.RendezVousRepo;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.*;
import java.util.Set;

@Service
@AllArgsConstructor
public class IRendezVousService implements ServiceRendezVous{
    private final PatientRepo patientRepo;
    private final MedecinRepo medecinRepo;
    private final RendezVousRepo rendezVousRepo;
    private final CliniqueRepo cliniqueRepo;
    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
        Patient patient = patientRepo.findById(idPatient).orElse(null);
        Medecin medecin = medecinRepo.findById(idMedecin).orElse(null);
        rdv.setPatient(patient);
        rdv.setMedecin(medecin);
        rendezVousRepo.save(rdv);
    }
    public Set<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        Clinique clinique=cliniqueRepo.findById(idClinique).orElse(null);
        Set<RendezVous>rendezVous=rendezVousRepo.findByMedecinSpecialiteAndMedecinCliniques(specialite,clinique);
        return rendezVous;
    }

    @Override
    @Scheduled(cron = "*/30 * * * * *")
    public void retrieveRendezVous() {
        Date date=new Date();
        Set<RendezVous>rendezVous=rendezVousRepo.findByDateRDVGreaterThan(date);
        System.out.println(rendezVous);
    }
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate){
        Medecin medecin=medecinRepo.findById(idMedecin).orElse(null);
        Set<RendezVous>rendezVous=rendezVousRepo.findByMedecinAndDateRDVAfterAndDateRDVBefore(medecin,startDate,endDate);
        return  rendezVous.size()*medecin.getPrixConsultation();
    }

}
