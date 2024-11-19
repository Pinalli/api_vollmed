package br.com.pinalli.med.voll.api.model.consultation.validations;

import br.com.pinalli.med.voll.api.model.consultation.DataSchedulingConsultation;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidateTimeInAdvance implements ValidatorSchedulingConsulatation {

    public void validate(DataSchedulingConsultation data) {
        var dateConsultation = data.data();
        var now = LocalDateTime.now();
        var differenceInMinutes = Duration.between(now, dateConsultation).toMinutes();

        if (differenceInMinutes < 30) {
            throw new RuntimeException("Consulta deve ser agendada com antecedência mínima de 30 minutos!");
        }
    }
}
