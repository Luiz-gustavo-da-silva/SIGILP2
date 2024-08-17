package br.ufrn.imd.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenericDAO<O> {

    private String pathFile;

    public String getCaminhoArquivo() {
        return pathFile;
    }

    public void setFilePath(String caminhoArquivo) {
        this.pathFile = caminhoArquivo;
    }

    public void registerKitnet(O obj) {
        File arquivo = new File(pathFile);
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            fw = new FileWriter(arquivo, true);
            bw = new BufferedWriter(fw);

            bw.write(obj.toString());
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*public List<obj> recuperarObj(String cpf){
        return
    }*/
}
