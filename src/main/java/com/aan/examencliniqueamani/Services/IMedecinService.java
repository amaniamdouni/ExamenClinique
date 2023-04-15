package com.aan.examencliniqueamani.Services;

import com.aan.examencliniqueamani.Entity.Clinique;
import com.aan.examencliniqueamani.Entity.Medecin;
import com.aan.examencliniqueamani.Entity.RendezVous;
import com.aan.examencliniqueamani.Repository.CliniqueRepo;
import com.aan.examencliniqueamani.Repository.MedecinRepo;
import com.aan.examencliniqueamani.Repository.RendezVousRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class IMedecinService implements ServiceMedecin{
    private final CliniqueRepo cliniqueRepo;
    private final MedecinRepo medecinRepo;
    private final RendezVousRepo rendezVousRepo;

    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
        Clinique clinique = cliniqueRepo.findById(cliniqueId).orElse(null);
        medecinRepo.saveAndFlush(medecin);
        Set<Medecin> medecins = clinique.getMedecins();
        medecins.add(medecin);
        clinique.setMedecins(medecins);
        cliniqueRepo.save(clinique);
        return medecin;
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
       Medecin medecin=medecinRepo.findById(idMedecin).orElse(null);
       Set<RendezVous>rendezVous = medecin.getRendezVous();
       return rendezVous.size();
    }


}
