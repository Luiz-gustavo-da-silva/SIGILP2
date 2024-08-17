package br.ufrn.imd.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenericDAO<O> {

    private String caminhoArquivo = "C:\\Users\\luizg\\OneDrive\\Documentos\\SIGILP2\\src\\main\\java\\br\\ufrn\\imd\\Files\\kitnets.txt";

    public void cadastrarKitnet(O obj) {
        File arquivo = new File(caminhoArquivo);
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
