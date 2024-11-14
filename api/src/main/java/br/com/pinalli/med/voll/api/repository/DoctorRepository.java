package br.com.pinalli.med.voll.api.repository;

import br.com.pinalli.med.voll.api.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
