package ma.fsm.hospital;

import ma.fsm.hospital.entities.*;
import ma.fsm.hospital.repositories.ConsultationRepository;
import ma.fsm.hospital.repositories.MedecinRepository;
import ma.fsm.hospital.repositories.PatientRepository;
import ma.fsm.hospital.repositories.RendezVousRepository;
import ma.fsm.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.management.monitor.GaugeMonitor;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository
            , RendezVousRepository rendezVousRepository, MedecinRepository medecinRepository) {
        return args -> {
            Stream.of("Mohamed", "Hassan", "Najat")
                    .forEach(name ->
                    {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Aymane", "Hanane", "Yasmine")
                    .forEach(name ->
                    {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);
                    });
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Mohamed");

            Medecin medecin= medecinRepository.findByNom("Yasmine");
            RendezVous rendezVous= new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            hospitalService.saveRDV(rendezVous);
            RendezVous saveDRDV = hospitalService.saveRDV(rendezVous);
            System.out.println(saveDRDV.getId());
            RendezVous rendezVous1 =rendezVousRepository.findAll().get(0);
            Consultation consultation= new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation...");
            hospitalService.saveConsultation(consultation);

        };
    }
}
