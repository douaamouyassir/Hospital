package org.example.hospital;

import org.example.hospital.entity.*;
import org.example.hospital.repositories.ConsultationRepository;
import org.example.hospital.repositories.MedecinRepository;
import org.example.hospital.repositories.PatientRepository;
import org.example.hospital.repositories.RendezVousRepository;
import org.example.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(PatientRepository patientRepository,
                                   RendezVousRepository rendezVousRepository,
                                   MedecinRepository medecinRepository,
                                    /*ConsultationRepository consultationRepository*/
                                    IHospitalService hospitalService) {
        return args -> {

            Stream.of("Mohammed", "Hassan", "Najat")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        /*patientRepository.save(patient);*/
                        hospitalService.savePatient(patient);
                    });


            Stream.of("Ayman", "Hanane", "Yasmine")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name + "@gmail.com");
                        medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
                        /*medecinRepository.save(medecin);*/
                        hospitalService.saveMedecin(medecin);
                    });


            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Mohamed");

            Medecin medecin = medecinRepository.findByNom("Yasmine");


                RendezVous rendezVous = new RendezVous();
                rendezVous.setDate(new Date());
                rendezVous.setStatus(StatusRDV.PENDING);
                rendezVous.setMedecin(medecin);
                rendezVous.setPatient(patient);
                RendezVous saveDRDV = hospitalService.saveRDV(rendezVous);

                System.out.println(saveDRDV.getId());

                RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
                Consultation consultation = new Consultation();
                consultation.setDateConsultation(new Date());
                consultation.setRendezVous(rendezVous1);
                consultation.setRapport("Rapport de la consultation......");
                /*consultationRepository.save(consultation);*/
                hospitalService.saveConsultation(consultation);



        };
    }
}