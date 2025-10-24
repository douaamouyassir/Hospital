package org.example.hospital.service;

import jakarta.transaction.Transactional;
import org.example.hospital.entity.Consultation;
import org.example.hospital.entity.Medecin;
import org.example.hospital.entity.Patient;
import org.example.hospital.entity.RendezVous;
import org.example.hospital.repositories.ConsultationRepository;
import org.example.hospital.repositories.MedecinRepository;
import org.example.hospital.repositories.PatientRepository;
import org.example.hospital.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class HospitalServiceImpl implements IHospitalService {

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository,MedecinRepository medecinRepository,RendezVousRepository rendezVousRepository,ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
