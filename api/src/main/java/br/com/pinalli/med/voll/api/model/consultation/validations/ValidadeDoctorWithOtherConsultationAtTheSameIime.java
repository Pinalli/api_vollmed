package br.com.pinalli.med.voll.api.model.consultation.validations;

import br.com.pinalli.med.voll.api.model.consultation.DataSchedulingConsultation;
import br.com.pinalli.med.voll.api.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadeDoctorWithOtherConsultationAtTheSameIime implements ValidatorSchedulingConsulatation{


    private final ConsultationRepository repository;

    public ValidadeDoctorWithOtherConsultationAtTheSameIime(ConsultationRepository repository) {
        this.repository = repository;
    }

    public void validate(DataSchedulingConsultation data) {
        var DoctorDoctorWithOtherConsultationAtTheSameIime = repository.existsByDoctorIdAndData(data.idDoctor(), data.data());
        if (DoctorDoctorWithOtherConsultationAtTheSameIime) {
            throw new RuntimeException("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}

