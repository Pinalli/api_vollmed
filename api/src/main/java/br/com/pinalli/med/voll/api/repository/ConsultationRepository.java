package br.com.pinalli.med.voll.api.repository;

import br.com.pinalli.med.voll.api.model.consultation.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long>{


    boolean existsByDoctorIdAndData(Long idDoctor, LocalDateTime data);

    boolean existsByPatientIdAndDataBetween( Long idPatient, LocalDateTime firstHour, LocalDateTime lastHour);
}
