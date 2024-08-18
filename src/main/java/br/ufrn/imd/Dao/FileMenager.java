package br.ufrn.imd.Dao;

import br.ufrn.imd.Models.Owner;

public class FileMenager {

    private String pathFile;

    public String getFilePath() {
        return pathFile;
    }

    public void setFilePath(String pathFile) {
        this.pathFile = pathFile;
    }

    public Owner readFile(){
        // Lógica de leitura aqui!

        return new Owner();
    }



}
