package br.com.pinalli.med.voll.api.repository;

import br.com.pinalli.med.voll.api.model.consultation.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
}
