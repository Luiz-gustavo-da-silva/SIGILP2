package br.ufrn.imd.Models;

import br.ufrn.imd.Dao.FileMenager;

import java.util.List;

public class Kitnet {
    public int nKitnet;
    public String furniture;
    public String tenantName;
    public String stateOfUse;
    public String cep;
    public String state;
    public String city;
    public String address;

    public Kitnet(int nKitnet, String furniture, String tenantName, String stateOfUse, String cep, String state, String city, String address) {
        this.nKitnet = nKitnet;
        this.furniture = furniture;
        this.tenantName = tenantName;
        this.stateOfUse = stateOfUse;
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.address = address;
    }

    public Kitnet(){}

    public Number getNKitnet() {
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

    public void setAddress(String address) {
        this.address = address;
    }

    /*public void registerKitnet(Kitnet kitnet){
        GenericDAO<Kitnet> kitnetGenericDAO = new GenericDAO<Kitnet>();
        // Esses caminhos podem ser enums!!!
        kitnetGenericDAO.setFilePath("C:\\Users\\luizg\\OneDrive\\Documentos\\SIGILP2\\src\\main\\java\\br\\ufrn\\imd\\Files\\kitnets.txt");
        kitnetGenericDAO.registerObj(kitnet);
    }*/

    public static List<Kitnet> recoverKitchenettes(){
        FileMenager fileMenager = new FileMenager();
        fileMenager.setFilePath("C:\\Users\\luizg\\OneDrive\\Documentos\\SIGILP2\\src\\main\\java\\br\\ufrn\\imd\\Files\\kitnets.txt");



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
