package br.ufrn.imd.Dao;

import br.ufrn.imd.Models.Kitnet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GenericDAO<O> {

    private String pathFile;

    public String getFilePath() {
        return pathFile;
    }

    public void setFilePath(String pathFile) {
        this.pathFile = pathFile;
    }

    public void registerObj(O obj) {
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

    public List<Kitnet> retrieveObj(String cpf) {
        List<Kitnet> kitchenettes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            String line;
            boolean correctCpf = false;

            while ((line = reader.readLine()) != null) {
                System.out.println("Linha lida: " + line); // Mensagem de depuração

                if (line.equals(cpf)) {
                    correctCpf = true;
                    continue;
                }

                if (correctCpf && line.startsWith("nKitnet:")) {
                    String[] attributes = line.split(", ");
                    Kitnet kitnet = new Kitnet();

                    for (String attribute : attributes) {
                        String[] keyValue = attribute.split(":");
                        if (keyValue.length == 2) {
                            System.out.println("Atributo: " + keyValue[0] + " Valor: " + keyValue[1]); // Mensagem de depuração
                            switch (keyValue[0].trim()) {
                                case "nKitnet":
                                    kitnet.setNKitnet(Integer.parseInt(keyValue[1]));
                                    break;
                                case "mobilia":
                                case "furniture":
                                    kitnet.setFurniture(keyValue[1].trim());
                                    break;
                                case "nomeInquilino":
                                case "tenantName":
                                    kitnet.setTenantName(keyValue[1].trim());
                                    break;
                                case "estadoUso":
                                case "stateOfUse":
                                    kitnet.setState(keyValue[1].trim());
                                    break;
                                // Outros atributos que você deseja mapear
                            }
                        } else {
                            System.out.println("Formato inválido: " + attribute); // Mensagem de depuração
                        }
                    }

                    kitchenettes.add(kitnet);
                }

                // Se encontrar outro CPF ou o fim do arquivo, parar de processar
                if (line.matches("\\d{11}")) {
                    if (correctCpf) break;
                    correctCpf = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return kitchenettes;
    }

}
