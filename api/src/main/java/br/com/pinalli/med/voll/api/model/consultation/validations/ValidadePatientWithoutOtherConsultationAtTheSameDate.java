package br.com.pinalli.med.voll.api.model.consultation.validations;

import br.com.pinalli.med.voll.api.model.consultation.DataSchedulingConsultation;
import br.com.pinalli.med.voll.api.repository.ConsultationRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidadePatientWithoutOtherConsultationAtTheSameDate implements ValidatorSchedulingConsulatation {

    private final ConsultationRepository consultationRepository;

    public ValidadePatientWithoutOtherConsultationAtTheSameDate(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public void validate(DataSchedulingConsultation data) {
        var firstHour = data.data().withHour(7);
        var lastHour = data.data().withHour(18);
        var patientWithOtherConsultationAtTheSameDay = consultationRepository.existsByPatientIdAndDataBetween(data.idPatient(), firstHour, lastHour);
        if (patientWithOtherConsultationAtTheSameDay) {
            throw new RuntimeException("Paciente já possui uma consulta agendada nesse dia");
        }
    }

}
