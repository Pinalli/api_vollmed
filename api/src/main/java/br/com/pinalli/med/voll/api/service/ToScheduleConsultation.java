package br.com.pinalli.med.voll.api.service;


import br.com.pinalli.med.voll.api.model.consultation.Consultation;
import br.com.pinalli.med.voll.api.model.consultation.DataSchedulingConsultation;
import br.com.pinalli.med.voll.api.model.doctor.Doctor;
import br.com.pinalli.med.voll.api.repository.ConsultationRepository;
import br.com.pinalli.med.voll.api.repository.DoctorRepository;
import br.com.pinalli.med.voll.api.repository.PatitentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToScheduleConsultation {

    @Autowired
    private ConsultationRepository consultationRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatitentRepository patitentRepository;

    //DTO
    public void toSchedule(@Valid DataSchedulingConsultation data) {
        if (!patitentRepository.existsById(data.idPatient())) {
            throw new EntityNotFoundException("Id do Paciente não encontrado");
        }
        if (data.idDoctor() != null && doctorRepository.existsById(data.idDoctor())) {
            throw new EntityNotFoundException("Id do Médico não encontrado");
        }

        var patient = patitentRepository.getReferenceById(data.idPatient());
        var doctor = chooseDoctor(data);
        var toSchedule = new Consultation(
                null,
                doctor,
                patient,
                data.data()
        );

        consultationRepository.save(toSchedule);
    }

    private Doctor chooseDoctor(@Valid DataSchedulingConsultation data) {
        if (data.idDoctor() != null) {
            return doctorRepository.getReferenceById(data.idDoctor());
        }
        if (data.specialtyDoctor() == null) {
            throw new EntityNotFoundException("Especialidade é obrigatória quando médico não for escolhido");
        }
        return doctorRepository.chooseRandomDoctorFreeOnDate(data.specialtyDoctor(), data.data());
    }
}