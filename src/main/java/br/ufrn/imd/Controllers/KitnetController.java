package br.ufrn.imd.Controllers;

import br.ufrn.imd.Models.Kitnet;

public class KitnetController {

    public boolean cadastrarKitnet(int nKitnet, String mobilia, String nomeInquilino, String estadoUso, String cep, String estado, String cidade, String endereco){
        if (nKitnet >= 0 && mobilia.length() > 0 && nomeInquilino.length()  > 0 && estadoUso.length() > 0 && isValidCep(cep) && estado.length() > 0 && cidade.length() > 0 && endereco.length() > 0){
            Kitnet kitnet = new Kitnet(nKitnet, mobilia, nomeInquilino, estadoUso, cep, estado, cidade, endereco);
            kitnet.cadastrarKitnet(kitnet);
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
