package br.com.pinalli.med.voll.api.model.consultation.validations;

import br.com.pinalli.med.voll.api.model.consultation.DataSchedulingConsultation;
import org.springframework.stereotype.Component;

@Component
public class ValidateClinicOpeningHours implements ValidatorSchedulingConsulatation {

    public void validateOpeningHours(DataSchedulingConsultation data) {

        var consultationDate = data.data();
        var sunday = consultationDate.getDayOfWeek().equals(java.time.DayOfWeek.SUNDAY);
        var beforeClinicOpening = consultationDate.getHour() < 7;
        var afterClinicClosing = consultationDate.getHour() > 18;
        if (sunday || beforeClinicOpening || afterClinicClosing) {
            throw new RuntimeException("Consulta fora do horário de funcionamento da clínica");
        }


    }

    @Override
    public void validate(DataSchedulingConsultation data) {

    }
}
