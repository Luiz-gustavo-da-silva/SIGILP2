package br.ufrn.imd.Dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.Models.Kitnet;
import br.ufrn.imd.Models.Owner;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class FileManager {

    private String pathFile;

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public void saveOwner(Owner owner) throws IOException {
        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy, h:mm:ss a").create();
        List<Owner> owners = readAllOwners();

        if (owners == null) {
            owners = new ArrayList<>();
        }

        owners.removeIf(o -> owner.getCpf().equals(o.getCpf()));
        owners.add(owner);

        try (FileWriter writeFile = new FileWriter(pathFile)) {
            gson.toJson(owners, writeFile);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
            throw e;
        }
    }

    public List<Owner> readAllOwners() throws IOException {
        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy, h:mm:ss a").create();
        String directoryPath = new File(pathFile).getParent();
        pathFile = directoryPath + File.separator + "owners.json";
        File file = new File(pathFile);

        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
                System.out.println("Arquivo criado em: " + pathFile);
            } catch (IOException e) {
                System.err.println("Erro ao criar o arquivo: " + e.getMessage());
                throw e;
            }
            return new ArrayList<>();
        }

        try (FileReader fileReader = new FileReader(file); JsonReader jsonReader = new JsonReader(fileReader)) {
            jsonReader.setLenient(true);
            return gson.fromJson(jsonReader, new TypeToken<List<Owner>>(){}.getType());
        } catch (JsonSyntaxException e) {
            System.err.println("Erro de sintaxe JSON: " + e.getMessage());
            return new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            throw e;
        }
    }

    public Owner readOwner(String cpf) throws IOException {
        List<Owner> owners = readAllOwners();
        if (owners != null) {
            for (Owner owner : owners) {
                if (owner.getCpf() != null && owner.getCpf().equals(cpf) && owner.isLogged()) {
                    return owner;
                }
            }
        }
        return null;
    }

    //Esse método retorno o usuário que está logado no sitema;
    public Owner readOwnerLogged() throws IOException {
        List<Owner> owners = readAllOwners();
        if (owners != null) {
            for (Owner owner : owners) {
                if (owner.isLogged()) {
                    return owner;
                }
            }
        }
        return null;
    }

    public boolean saveKitnet(Kitnet kitnet) {
        Owner o = new Owner();
        try {
            o = readOwnerLogged();
            o.getKitnets().add(kitnet);
            saveOwner(o);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
