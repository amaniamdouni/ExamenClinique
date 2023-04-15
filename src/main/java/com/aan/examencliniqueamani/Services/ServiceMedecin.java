package com.aan.examencliniqueamani.Services;

import com.aan.examencliniqueamani.Entity.Medecin;

import java.util.Date;

public interface ServiceMedecin {
    public Medecin addMedecinAndAssignToClinique (Medecin medecin, Long cliniqueId);
    public int getNbrRendezVousMedecin(Long idMedecin);

}
