package br.com.tokiomarine.seguradora.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultDTO {
    private String street;
    private String complement;
    private String district;
    private String districtId;
    private String city;
    private String cityId;
    private String ibgeId;
    private String state;
    private String stateIbgeId;
    private String stateShortname;
    private String zipcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getIbgeId() {
        return ibgeId;
    }

    public void setIbgeId(String ibgeId) {
        this.ibgeId = ibgeId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateIbgeId() {
        return stateIbgeId;
    }

    public void setStateIbgeId(String stateIbgeId) {
        this.stateIbgeId = stateIbgeId;
    }

    public String getStateShortname() {
        return stateShortname;
    }

    public void setStateShortname(String stateShortname) {
        this.stateShortname = stateShortname;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
