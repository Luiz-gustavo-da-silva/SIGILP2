package br.ufrn.imd.Controllers;

public class KitnetController {

    public boolean cadastrarKitnet(Number nKitnet, String mobilia, String nomeInquilino, String estadoUso, String cep, String estado, String cidade, String esdereco){
        if (nKitnet != null && mobilia != null && nomeInquilino != null && estadoUso != null && cep != null && estado != null && cidade != null && esdereco != null){
            return true;
        }
        return false;
    }
}
