package ma.fsm.hospital.service;

import jakarta.transaction.Transactional;
import ma.fsm.hospital.entities.Consultation;
import ma.fsm.hospital.entities.Medecin;
import ma.fsm.hospital.entities.Patient;
import ma.fsm.hospital.entities.RendezVous;
import ma.fsm.hospital.repositories.ConsultationRepository;
import ma.fsm.hospital.repositories.MedecinRepository;
import ma.fsm.hospital.repositories.PatientRepository;
import ma.fsm.hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;
    public IHospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository,
                                RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
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
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }
    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
