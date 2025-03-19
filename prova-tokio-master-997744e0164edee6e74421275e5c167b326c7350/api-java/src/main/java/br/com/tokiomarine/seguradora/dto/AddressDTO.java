package br.com.tokiomarine.seguradora.dto;

import br.com.tokiomarine.seguradora.entities.Address;

import javax.validation.constraints.NotBlank;

public class AddressDTO {
    private Long id;
    @NotBlank(message = "Campo requerido")
    private String address;
    @NotBlank(message = "Campo requerido")
    private String number;
    private String complement;
    private String postalCode;
    private String city;
    private String state;
    private String country;
    private Long clientId;
    public AddressDTO() {}
    public AddressDTO(Long id, String address, String number, String complement, String postalCode, String city, String state, String country, ClientDTO client) {
        this.id = id;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public AddressDTO(Address entity) {
        id = entity.getId();
        address = entity.getAddress();
        number = entity.getNumber();
        complement = entity.getComplement();
        postalCode = entity.getPostalCode();
        city = entity.getCity();
        state = entity.getState();
        country = entity.getCountry();
        clientId = entity.getClient().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
