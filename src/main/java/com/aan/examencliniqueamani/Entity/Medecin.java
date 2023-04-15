package com.aan.examencliniqueamani.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long idMedecin;
    private String nomMedecin;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private int telephone;
    private int prixConsultation;

    @ManyToMany(mappedBy = "medecins")
    private Set<Clinique> cliniques;

    @OneToMany(mappedBy = "medecin")
    private Set<RendezVous> rendezVous;
}
