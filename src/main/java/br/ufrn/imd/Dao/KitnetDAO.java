package br.ufrn.imd.Dao;

import br.ufrn.imd.Models.Kitnet;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class KitnetDAO {

    private String caminhoArquivo = "C:\\Users\\luizg\\OneDrive\\Documentos\\SIGILP2\\src\\main\\java\\br\\ufrn\\imd\\Files\\kitnets.txt";

    public void cadastrarKitnet(Kitnet kitnet) {
        File arquivo = new File(caminhoArquivo);
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            fw = new FileWriter(arquivo, true);
            bw = new BufferedWriter(fw);

            bw.write(kitnet.toString());
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

    /*public List<Kitnet> recuperarKitnets(String cpf){
        return
    }*/
}
