package br.ufrn.imd.Controllers;

import br.ufrn.imd.Dao.FileManager;
import br.ufrn.imd.Models.Kitnet;

import java.util.List;

public class KitnetController {

    FileManager fm = new FileManager();

    public boolean registerKitnet(Kitnet kitnet){
        if(validationKitnet(kitnet)){
            return fm.saveKitnet(kitnet);
        }
        return false;
    }

    public boolean kitnetExists(int nKitnet){
        return fm.kitnetExists(nKitnet);
    }

    public List<Kitnet> recoverKitchenettes(){
        return fm.searchKitchenettes();
    }

    public boolean removeKitnet(int nKitnet){
        return fm.removeKitnet(nKitnet);
    }

    public Kitnet searchKitnet(int nKitnet){
        return fm.searchKitnet(nKitnet);
    }

    public boolean editKitnet(Kitnet kitnet){
        if (validationKitnet(kitnet)){
            return fm.editKitnet(kitnet);
        }
        return false;
    }

    public boolean validationKitnet(Kitnet kitnet){
        if (kitnet.furniture.length() > 0 && kitnet.stateOfUse.length() > 0 && isValidCep(kitnet.cep) && kitnet.state.length() > 0 && kitnet.city.length() > 0 && kitnet.address.length() > 0 && kitnet.nameKitnet.length() >= 0){
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
