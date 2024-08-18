package br.ufrn.imd.Dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.Enums.FilePaths;
import br.ufrn.imd.Models.Contract;
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

        Owner fakeOwner = new Owner();
        if (owners.isEmpty()) {
            owners.add(fakeOwner);
        }

        owners.removeIf(o -> owner.getCpf().equals(o.getCpf()));
        owners.add(owner);

        try (FileWriter writeFile = new FileWriter(pathFile)) {
            gson.toJson(owners, writeFile);
        }
    }

    public List<Owner> readAllOwners() throws IOException {
        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy, h:mm:ss a").create();
        String directoryPath = new File(pathFile).getParent();
        pathFile = directoryPath + File.separator + "owners.json";
        File file = new File(pathFile);


        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
            System.out.println("Arquivo criado: " + pathFile);
            return new ArrayList<>();
        }

        try (FileReader fileReader = new FileReader(file);
             JsonReader jsonReader = new JsonReader(fileReader)) {
            jsonReader.setLenient(true);
            return gson.fromJson(jsonReader, new TypeToken<List<Owner>>(){}.getType());
        } catch (JsonSyntaxException e) {
            System.out.println("Erro de sintaxe JSON.");
            return new ArrayList<>();
        }
    }



    public Owner readOwner(String name) throws IOException {
        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy, h:mm:ss a").create();
        try (FileReader fileReader = new FileReader(pathFile);
             JsonReader jsonReader = new JsonReader(fileReader)) {
            jsonReader.setLenient(true);
            List<Owner> owners = readAllOwners();
            for (Owner owner : owners) {
                if (owner.getName() != null) {
                    if (owner.getName().equals(name) && owner.isLogged()) {
                        return owner;
                    }
                }

            }
        }
        return null;
    }
}
