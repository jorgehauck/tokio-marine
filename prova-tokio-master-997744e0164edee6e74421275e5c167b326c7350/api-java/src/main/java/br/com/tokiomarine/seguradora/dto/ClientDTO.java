package br.com.tokiomarine.seguradora.dto;


import br.com.tokiomarine.seguradora.entities.Client;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientDTO {
    private Long id;
    @NotBlank(message = "Campo requerido")
    private String firstName;
    private String lastName;
    @NotBlank(message = "Campo requerido")
    @Email(message = "Formato de e-mail inválido")
    private String email;
    private List<AddressDTO> addresses = new ArrayList<>();
    public ClientDTO() {}
    public ClientDTO(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public ClientDTO(Client entity) {
        id = entity.getId();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();
        addresses = entity.getAddresses().stream().map(x -> new AddressDTO(x)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<AddressDTO> getAddresses() {
        return addresses;
    }
}
