package br.com.pinalli.med.voll.api.model.patient;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressPatient {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public AddressPatient(DataAddressPatient daata) {
        this.logradouro = daata.logradouro();
        this.bairro = daata.bairro();
        this.cep = daata.cep();
        this.uf = daata.uf();
        this.cidade = daata.cidade();
        this.numero = daata.numero();
        this.complemento = daata.complemento();
    }

    public void updateAddressPatient(DataAddressPatient dataAddressPatient) {
        if (dataAddressPatient.logradouro() != null) {
            this.logradouro = dataAddressPatient.logradouro();
        }
        if (dataAddressPatient.bairro() != null) {
            this.bairro = dataAddressPatient.bairro();
        }
        if (dataAddressPatient.cep() != null) {
            this.cep = dataAddressPatient.cep();
        }
        if (dataAddressPatient.uf() != null) {
            this.uf = dataAddressPatient.uf();
        }
        if (dataAddressPatient.cidade() != null) {
            this.cidade = dataAddressPatient.cidade();
        }
        if (dataAddressPatient.numero() != null) {
            this.numero = dataAddressPatient.numero();
        }
        if (dataAddressPatient.complemento() != null) {
            this.complemento = dataAddressPatient.complemento();
        }
    }
}
