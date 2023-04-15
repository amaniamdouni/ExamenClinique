package com.aan.examencliniqueamani.Controller;

import com.aan.examencliniqueamani.Entity.RendezVous;
import com.aan.examencliniqueamani.Entity.Specialite;
import com.aan.examencliniqueamani.Services.ServiceRendezVous;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("rdv")
public class RendezVousControlleur {
    private final ServiceRendezVous serviceRendezVous;
    @PostMapping("/add/{idMedecin}/{idPatient}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv, @PathVariable Long idMedecin,@PathVariable Long idPatient){
       serviceRendezVous.addRDVAndAssignMedAndPatient(rdv,idMedecin,idPatient);
    }

    @GetMapping("/get/{idClinique}/{specialite}")
    public Set<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable Long idClinique, @PathVariable Specialite specialite){
        return serviceRendezVous.getRendezVousByCliniqueAndSpecialite(idClinique,specialite);
    }
    @GetMapping("/getrev/{idMedecin}/{startDate}/{endDate}")
    public int getRevenuMedecin(@PathVariable("idMedecin") Long idMedecin,
                                @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate){
        return serviceRendezVous.getRevenuMedecin(idMedecin,startDate,endDate);
    }
    @GetMapping("/retrieve")
    public void retrieveRendezVous(){
        serviceRendezVous.retrieveRendezVous();
    }
}
