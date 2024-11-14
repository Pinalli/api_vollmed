package br.com.pinalli.med.voll.api.repository;

import br.com.pinalli.med.voll.api.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatitentRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findAllByAtivoTrue(Pageable paginacao);
}
