package br.ufrn.imd.Controllers;

import br.ufrn.imd.Dao.FileManager;
import br.ufrn.imd.Models.Contract;
import br.ufrn.imd.Models.Kitnet;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

public class KitnetController implements ControllerUtils<Kitnet>{

    FileManager fm = new FileManager();

    public boolean registerKitnet(Kitnet kitnet){
        if(validationKitnet(kitnet)){
            return fm.saveKitnet(kitnet);
        }
        return false;
    }

    public boolean kitnetExists(UUID nKitnetUUID){
        return fm.kitnetExists(nKitnetUUID);
    }

    public List<Kitnet> recoverKitchenettes(){
        return fm.searchKitchenettes();
    }

    public boolean removeKitnet(UUID nKitnetUUID){
        return fm.removeKitnet(nKitnetUUID);
    }

    public Kitnet searchKitnet(UUID nKitnetUUID){
        return fm.searchKitnet(nKitnetUUID);
    }

    public boolean editKitnet(Kitnet kitnet){
        if (validationKitnet(kitnet)){
            return fm.editKitnet(kitnet);
        }
        return false;
    }

    public boolean validationKitnet(Kitnet kitnet){
        if (kitnet.getFurniture().length() > 0 && kitnet.getStateOfUse().length() > 0 && kitnet.getCep().length() > 0 && kitnet.getState().length() > 0 && kitnet.getCity().length() > 0 && kitnet.getAddress().length() > 0 && kitnet.getNameKitnet().length() > 0 && kitnet.getnKitnetUUID() != null){
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

    @Override
    public Object[][] convertListToArray(List<Kitnet> kitnets) {
        Object[][] data = new Object[kitnets.size()][10];

        for (int i = 0; i < kitnets.size(); i++) {
            Kitnet kitnet = kitnets.get(i);
            data[i][0] = kitnet.getNameKitnet();
            data[i][1] = kitnet.getFurniture();
            data[i][2] = kitnet.getStateOfUse();
            data[i][3] = kitnet.getCep();
            data[i][4] = kitnet.getState();
            data[i][5] = kitnet.getCity();
            data[i][6] = kitnet.getAddress();
            data[i][7] = "Editar";
            data[i][8] = "Deletar";
        }
        return data;
    }
}
