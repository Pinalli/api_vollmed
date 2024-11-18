package br.com.pinalli.med.voll.api.repository;

import br.com.pinalli.med.voll.api.model.doctor.Doctor;
import br.com.pinalli.med.voll.api.model.doctor.SpecialtyDoctor;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Page<Doctor> findAllByActiveTrue(Pageable pagination);

    @Query("""
             select m from Medico m
             where
             m.active = true
             and
             m.especialidade = :specialtyDoctor
             and
             m.id not in(
                        select c.doctor  from Consulta  c
                        where\s
                        c.data = :data
                        )
             order by function('RAND')
             limit 1
           \s""")
    Doctor chooseRandomDoctorFreeOnDate(SpecialtyDoctor specialtyDoctor, LocalDateTime data);
}

