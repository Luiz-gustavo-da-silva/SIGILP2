package br.ufrn.imd.Models;

import java.util.UUID;

public class Kitnet {
    private String furniture;
    private String stateOfUse;
    private String cep;
    private String state;
    private String city;
    private String address;
    private String nameKitnet;
    private UUID nKitnetUUID = UUID.randomUUID();

    public Kitnet(UUID nKitnetUUID, String furniture, String stateOfUse, String cep, String state, String city, String address, String nameKitnet) {
        this.nKitnetUUID = nKitnetUUID;
        this.furniture = furniture;
        this.stateOfUse = stateOfUse;
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.address = address;
        this.nameKitnet = nameKitnet;
    }

    public Kitnet(){}

    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    public String getStateOfUse() {
        return stateOfUse;
    }

    public void setStateOfUse(String stateOfUse) {
        this.stateOfUse = stateOfUse;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameKitnet() {
        return nameKitnet;
    }

    public void setNameKitnet(String nameKitnet) {
        this.nameKitnet = nameKitnet;
    }

    public UUID getnKitnetUUID() {
        return nKitnetUUID;
    }

}
