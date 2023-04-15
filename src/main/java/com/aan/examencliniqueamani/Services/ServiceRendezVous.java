package com.aan.examencliniqueamani.Services;

import com.aan.examencliniqueamani.Entity.RendezVous;
import com.aan.examencliniqueamani.Entity.Specialite;

import java.util.Date;
import java.util.Set;

public interface ServiceRendezVous {
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);
    public Set<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);
    public void retrieveRendezVous();
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate);
}
