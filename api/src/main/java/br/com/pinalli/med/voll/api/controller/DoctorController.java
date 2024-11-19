package br.com.pinalli.med.voll.api.controller;

import br.com.pinalli.med.voll.api.model.doctor.*;
import br.com.pinalli.med.voll.api.repository.DoctorRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("medicos")
@SecurityRequirement(name = "bearer-key")
public class DoctorController {

    private final DoctorRepository repository;

    public DoctorController(DoctorRepository medicoRepository) {
        this.repository = medicoRepository;
    }

    @PostMapping
    @Transactional
    public  ResponseEntity<DetailsDataDoctor> register(@RequestBody @Valid DataRegisterDoctor data, UriComponentsBuilder uriBuilder){
        var doctor = new Doctor(data);
        repository.save(doctor);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailsDataDoctor(doctor));
    }

    @GetMapping
    public  ResponseEntity<Page<DataListDoctor>>list(Pageable pagination){
       var page =  repository.findAllByActiveTrue(pagination).map(DataListDoctor::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<DetailsDataDoctor> detail(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetailsDataDoctor(doctor));
    }

    @PutMapping
    @Transactional
    public  ResponseEntity<DetailsDataDoctor> update(@RequestBody @Valid DataUpdateRegisterDoctor data){
        var doctor = repository.getReferenceById(data.id());
        doctor.updateData(data);
        return ResponseEntity.ok(new DetailsDataDoctor(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Doctor> delete(@PathVariable Long id){
       // repository.deleteById(id); //exclusao fisica
        var doctor = repository.getReferenceById(id); //exclusao lógica
        doctor.delete();

        return ResponseEntity.noContent().build();
    }
}
