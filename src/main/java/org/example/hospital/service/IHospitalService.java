package org.example.hospital.service;

import org.example.hospital.entity.Consultation;
import org.example.hospital.entity.Medecin;
import org.example.hospital.entity.Patient;
import org.example.hospital.entity.RendezVous;

public interface IHospitalService {
     Patient savePatient(Patient patient);
     Medecin saveMedecin(Medecin medecin);
     RendezVous saveRDV(RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);
}
