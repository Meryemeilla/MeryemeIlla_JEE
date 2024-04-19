package ma.fsm.hospital.service;

import ma.fsm.hospital.entities.Consultation;
import ma.fsm.hospital.entities.Medecin;
import ma.fsm.hospital.entities.Patient;
import ma.fsm.hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
