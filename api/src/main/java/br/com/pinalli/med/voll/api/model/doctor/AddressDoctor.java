package br.com.pinalli.med.voll.api.model.doctor;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDoctor {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public AddressDoctor(DataAddressDoctor data) {
        this.logradouro = data.logradouro();
        this.bairro = data.bairro();
        this.cep = data.cep();
        this.uf = data.uf();
        this.cidade = data.cidade();
        this.numero = data.numero();
        this.complemento = data.complemento();
    }

    public void updateAddressDoctor(DataAddressDoctor dataAddressDoctor) {
        if (dataAddressDoctor.logradouro() != null){
            this.logradouro = dataAddressDoctor.logradouro();
        }
        if (dataAddressDoctor.bairro() != null){
            this.bairro = dataAddressDoctor.bairro();
        }
        if (dataAddressDoctor.cep() != null){
            this.cep = dataAddressDoctor.cep();
        }
        if (dataAddressDoctor.uf() != null){
            this.uf = dataAddressDoctor.uf();
        }
        if (dataAddressDoctor.cidade() != null){
            this.cidade = dataAddressDoctor.cidade();
        }
        if (dataAddressDoctor.numero() != null){
            this.numero = dataAddressDoctor.numero();
        }
        if (dataAddressDoctor.complemento() != null){
            this.complemento = dataAddressDoctor.complemento();
        }
    }
}
