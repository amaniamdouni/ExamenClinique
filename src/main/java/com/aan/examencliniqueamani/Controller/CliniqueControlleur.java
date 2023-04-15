package com.aan.examencliniqueamani.Controller;

import com.aan.examencliniqueamani.Entity.Clinique;
import com.aan.examencliniqueamani.Services.ServiceClinique;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/clinique")
public class CliniqueControlleur {

    private ServiceClinique serviceClinique;
    @PostMapping("/add")
    public Clinique addClinique (@RequestBody Clinique clinique){
        return serviceClinique.addClinique(clinique);
    }
}
