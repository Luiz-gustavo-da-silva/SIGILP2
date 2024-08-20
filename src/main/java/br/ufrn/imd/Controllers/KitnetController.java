package br.ufrn.imd.Controllers;

import br.ufrn.imd.Models.Kitnet;

import java.util.List;

public class KitnetController {

    public boolean registerKitnet(Kitnet kitnet){
        if(validationKitnet(kitnet)){
            return kitnet.registerKitnet(kitnet);
        }
        return false;
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

    public Kitnet searchKitnet(int nKitnet){
        Kitnet kitnet = new Kitnet();
        return kitnet.searchKitnet(nKitnet);
    }

    public boolean editKitnet(Kitnet kit){
        if (validationKitnet(kit)){
            return kit.editKitnet(kit);
        }
        return false;
    }

    public boolean validationKitnet(Kitnet kitnet){
        if (kitnet.nKitnet >= 0 && kitnet.furniture.length() > 0 && kitnet.tenantName.length() >= 0 && kitnet.stateOfUse.length() > 0 && isValidCep(kitnet.cep) && kitnet.state.length() > 0 && kitnet.city.length() > 0 && kitnet.address.length() > 0 && kitnet.nContract >= -1 && kitnet.nameKitnet.length() >= 0){
            return true;
        }
        return false;
    }

    public static boolean isValidCep(String cep) {
        String cleanedCep = cep.replaceAll("\\D", "");
        if (cleanedCep.length() != 8) {
            return false;
        }
        return cleanedCep.matches("\\d{8}");
    }
}
