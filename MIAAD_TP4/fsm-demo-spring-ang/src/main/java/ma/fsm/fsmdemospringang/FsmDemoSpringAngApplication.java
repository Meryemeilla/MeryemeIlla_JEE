package ma.fsm.fsmdemospringang;

import ma.fsm.fsmdemospringang.entities.Payment;
import ma.fsm.fsmdemospringang.entities.PaymentStatus;
import ma.fsm.fsmdemospringang.entities.PaymentType;
import ma.fsm.fsmdemospringang.entities.Student;
import ma.fsm.fsmdemospringang.repository.PaymentRepository;
import ma.fsm.fsmdemospringang.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class FsmDemoSpringAngApplication {

    public static void main(String[] args) {
        SpringApplication.run(FsmDemoSpringAngApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        PaymentRepository paymentRepository){
        return args -> {
            studentRepository.save(Student.builder().Id(UUID.randomUUID().toString())
                    .firstName("Meryeme").code("112233").programId("SDIA")
                    .build());
            studentRepository.save(Student.builder().Id(UUID.randomUUID().toString())
                    .firstName("Asmae").code("112244").programId("SDIA")
                    .build());
            studentRepository.save(Student.builder().Id(UUID.randomUUID().toString())
                    .firstName("Chaymae").code("112255").programId("IAAD")
                    .build());
            studentRepository.save(Student.builder().Id(UUID.randomUUID().toString())
                    .firstName("Fatima").code("112266").programId("BDCC")
                    .build());

            PaymentType[] paymentTypes = PaymentType.values();
            Random random = new Random();
            studentRepository.findAll().forEach(st -> {
                for (int i=0; i<10; i++){
                    int index = random.nextInt(paymentTypes.length);
                    Payment payment = Payment.builder()
                            .amount(1000+(int)(Math.random()+20000))
                            .type(paymentTypes[index])
                            .status(PaymentStatus.CREATED)
                            .date(LocalDate.now())
                            .student(st)
                            .build();
                    paymentRepository.save(payment);
                }
            });
        };
    }
}

