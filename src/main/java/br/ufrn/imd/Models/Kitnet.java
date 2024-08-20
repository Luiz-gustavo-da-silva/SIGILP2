package br.ufrn.imd.Models;

import br.ufrn.imd.Dao.FileManager;
import br.ufrn.imd.Dao.FileManager;
import com.sun.tools.jconsole.JConsoleContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kitnet {
    public int nKitnet;
    public int nContract;
    public String furniture;
    public String tenantName;
    public String stateOfUse;
    public String cep;
    public String state;
    public String city;
    public String address;
    public String nameKitnet;

    public Kitnet(int nKitnet, String furniture, String tenantName, String stateOfUse, String cep, String state, String city, String address, int nContract, String nameKitnet) {
        this.nKitnet = nKitnet;
        this.furniture = furniture;
        this.tenantName = tenantName;
        this.stateOfUse = stateOfUse;
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.address = address;
        this.nContract = nContract;
        this.nameKitnet = nameKitnet;
    }

    public Kitnet(){}

    public int getNKitnet() {
        return nKitnet;
    }

    public void setNKitnet(int nKitnet) {
        this.nKitnet = nKitnet;
    }

    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
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

    public int getnContract() {
        return nContract;
    }

    public void setnContract(int nContract) {
        this.nContract = nContract;
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

    @Override
    public String toString() {
        return "nKitnet:" + nKitnet +
                ", furniture:" + furniture +
                ", tenantName:" + tenantName +
                ", stateOfUse:" + stateOfUse +
                ", cep:" + cep +
                ", state:" + state +
                ", city:" + city +
                ", address:" + address;
    }
}
