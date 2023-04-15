package com.aan.examencliniqueamani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ExamenCliniqueAmaniApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenCliniqueAmaniApplication.class, args);
    }

}
