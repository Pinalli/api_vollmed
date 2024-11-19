package br.com.pinalli.med.voll.api.repository;

import br.com.pinalli.med.voll.api.model.patient.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatitentRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findAllByAtivoTrue(Pageable paginacao);


    @Query("""
            select p.ativo
            from Paciente p
            where
            p.id = :id
            """)
    boolean findActiveById(Long id);
}
