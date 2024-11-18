package br.com.pinalli.med.voll.api.repository;

import br.com.pinalli.med.voll.api.model.doctor.Doctor;
import br.com.pinalli.med.voll.api.model.doctor.SpecialtyDoctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Page<Doctor> findAllByActiveTrue(Pageable pagination);
    @Query("SELECT m FROM Medico  m WHERE m.especialidade= :specialty AND m.id NOT IN (SELECT c.doctor.id " +
            "FROM Consulta c WHERE c.data = :dateTime) ORDER BY FUNCTION('RAND')")
    Doctor chooseRandomDoctorFreeOnDate(@Param("specialty") SpecialtyDoctor specialty, @Param("dateTime") LocalDateTime dateTime);}
