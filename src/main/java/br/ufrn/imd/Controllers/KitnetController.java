package br.ufrn.imd.Controllers;

import br.ufrn.imd.Models.Kitnet;

import java.util.List;

public class KitnetController {

    public boolean registerKitnet(int nKitnet, String furniture, String tenantName, String stateOfUse, String cep, String state, String city, String address, int nContract){
        if (nKitnet >= 0 && furniture.length() > 0 && tenantName.length()  > 0 && stateOfUse.length() > 0 && isValidCep(cep) && state.length() > 0 && city.length() > 0 && address.length() > 0 && nContract >= -1){
            Kitnet kitnet = new Kitnet(nKitnet, furniture, tenantName, stateOfUse, cep, state, city, address, nContract);
            return kitnet.registerKitnet(kitnet);
        }
        return false;
    }

    public int checkContractNumber(int nConstract, int nKitnet){
        Kitnet kitnet = new Kitnet();
        return kitnet.checkContractNumber(nConstract, nKitnet);
    }

    public boolean kitnetExists(int nKitnet){
        Kitnet kitnet = new Kitnet();
        return kitnet.kitnetExists(nKitnet);
    }

    public List<Kitnet> recoverKitchenettes(){
        Kitnet kitnet = new Kitnet();
        return kitnet.recoverKitchenettes();
    }

    public boolean removeKitnet(int nKitnet){
        Kitnet kitnet = new Kitnet();
        return kitnet.removeKitnet(nKitnet);
    }

    public static boolean isValidCep(String cep) {
        String cleanedCep = cep.replaceAll("\\D", "");

        if (cleanedCep.length() != 8) {
            return false;
        }

        return cleanedCep.matches("\\d{8}");
    }

}
