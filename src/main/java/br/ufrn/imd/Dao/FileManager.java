package br.ufrn.imd.Dao;

import java.io.*;
import br.ufrn.imd.Enums.FilePaths;
import br.ufrn.imd.Models.Contract;
import br.ufrn.imd.Models.Kitnet;
import br.ufrn.imd.Models.Owner;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class FileManager {

    private String pathFile;

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public void saveOwner(Owner owner) throws IOException {
        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy, h:mm:ss a").create();
        String json = gson.toJson(owner);
        try (FileWriter writeFile = new FileWriter(pathFile, true)) {
            writeFile.write(json);
        }
    }

    public Owner readOwner() throws IOException {
        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy, h:mm:ss a").create();
        try (FileReader fileReader = new FileReader(pathFile);
             JsonReader jsonReader = new JsonReader(fileReader)) {
            jsonReader.setLenient(true);
            return gson.fromJson(jsonReader, Owner.class);
        }
    }
}
