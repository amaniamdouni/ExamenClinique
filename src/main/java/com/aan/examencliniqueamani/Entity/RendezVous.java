package com.aan.examencliniqueamani.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long idRVD;
    private Date dateRDV;
    private String remarque;

    @ManyToOne
    private Medecin medecin;

    @ManyToOne
    private Patient patient;
}
