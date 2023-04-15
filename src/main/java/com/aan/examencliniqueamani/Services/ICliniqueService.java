package com.aan.examencliniqueamani.Services;

import com.aan.examencliniqueamani.Entity.Clinique;
import com.aan.examencliniqueamani.Repository.CliniqueRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ICliniqueService implements ServiceClinique{
    private final CliniqueRepo cliniqueRepo;
    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepo.save(clinique);
    }
}
