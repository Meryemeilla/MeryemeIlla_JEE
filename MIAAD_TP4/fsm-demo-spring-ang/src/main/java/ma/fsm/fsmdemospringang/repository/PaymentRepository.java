package ma.fsm.fsmdemospringang.repository;

import ma.fsm.fsmdemospringang.entities.Payment;
import ma.fsm.fsmdemospringang.entities.PaymentStatus;
import ma.fsm.fsmdemospringang.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);

}
