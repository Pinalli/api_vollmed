package br.com.pinalli.med.voll.api.controller;

import br.com.pinalli.med.voll.api.model.DataListDoctor;
import br.com.pinalli.med.voll.api.model.DataRegisterDoctor;
import br.com.pinalli.med.voll.api.model.DataUpdateRegisterDoctor;
import br.com.pinalli.med.voll.api.model.Doctor;
import br.com.pinalli.med.voll.api.repository.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("medicos")
public class DoctorController {

    private final DoctorRepository repository;

    public DoctorController(DoctorRepository medicoRepository) {
        this.repository = medicoRepository;
    }

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataRegisterDoctor data){
        repository.save(new Doctor(data));
    }

    @GetMapping
    public Page<DataListDoctor> list(Pageable pagination){
        return repository.findAllByActiveTrue(pagination).map(DataListDoctor::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdateRegisterDoctor data){
        var doctor = repository.getReferenceById(data.id());
        doctor.updateData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
       // repository.deleteById(id); //exclusao fisica
        var doctor = repository.getReferenceById(id); //exclusao lógica
        doctor.delete();
    }
}
