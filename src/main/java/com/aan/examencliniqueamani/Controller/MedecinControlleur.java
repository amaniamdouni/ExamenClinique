package com.aan.examencliniqueamani.Controller;

import com.aan.examencliniqueamani.Entity.Medecin;
import com.aan.examencliniqueamani.Services.ServiceMedecin;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medecin")
@AllArgsConstructor
public class MedecinControlleur {
    private final ServiceMedecin serviceMedecin;

    @PostMapping("/add/{cliniqueId}")
    public Medecin addMedecinAndAssignToClinique (@RequestBody Medecin medecin, @PathVariable Long cliniqueId){
      return serviceMedecin.addMedecinAndAssignToClinique(medecin,cliniqueId);
    }
    @GetMapping("/getnbr/{idMedecin}")
    public int getNbrRendezVousMedecin(@PathVariable Long idMedecin){
    return serviceMedecin.getNbrRendezVousMedecin(idMedecin);
    }
}
