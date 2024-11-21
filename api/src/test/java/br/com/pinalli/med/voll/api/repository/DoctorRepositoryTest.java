package br.com.pinalli.med.voll.api.repository;

import br.com.pinalli.med.voll.api.model.doctor.Doctor;
import br.com.pinalli.med.voll.api.model.doctor.SpecialtyDoctor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class DoctorRepositoryTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    @DisplayName("Should return a doctor when a doctor is available on the date")
    void chooseRandomDoctorFreeOnDateWithNoAvailableDoctor1() {

        LocalDate nextMonday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDateTime nextMonday10 = nextMonday.atTime(10, 0);
        Optional<Doctor> freeDoctor = Optional.ofNullable(doctorRepository.chooseRandomDoctorFreeOnDate(SpecialtyDoctor.CARDIOLOGIA, nextMonday10));
        assertThat(freeDoctor).isEmpty();
    }
}


