package br.com.pinalli.med.voll.api.repository;

import br.com.pinalli.med.voll.api.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
