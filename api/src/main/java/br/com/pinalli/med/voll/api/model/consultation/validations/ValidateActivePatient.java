package br.com.pinalli.med.voll.api.model.consultation.validations;

import br.com.pinalli.med.voll.api.model.consultation.DataSchedulingConsultation;
import br.com.pinalli.med.voll.api.repository.PatitentRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateActivePatient implements ValidatorSchedulingConsulatation {

    private final PatitentRepository patitentRepository;

    public ValidateActivePatient(PatitentRepository patitentRepository) {
        this.patitentRepository = patitentRepository;
    }

    public void validate(DataSchedulingConsultation data) {
        var patientIsActive = patitentRepository.findActiveById(data.idPatient());
        if (!patientIsActive) {
            throw new RuntimeException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
