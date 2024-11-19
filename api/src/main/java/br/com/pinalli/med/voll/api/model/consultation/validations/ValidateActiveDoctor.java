package br.com.pinalli.med.voll.api.model.consultation.validations;

import br.com.pinalli.med.voll.api.model.consultation.DataSchedulingConsultation;
import br.com.pinalli.med.voll.api.repository.DoctorRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateActiveDoctor implements ValidatorSchedulingConsulatation {

    private final DoctorRepository doctorRepository;

    public ValidateActiveDoctor(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void validate(DataSchedulingConsultation data) {
        if (data.idDoctor() == null) {
            return;
        }

        var doctorIsActive = doctorRepository.findActiveById(data.idDoctor());
        if (!doctorIsActive) {
            throw new RuntimeException("Consulta não pode ser agendada com médico excluído");
        }
    }
}
