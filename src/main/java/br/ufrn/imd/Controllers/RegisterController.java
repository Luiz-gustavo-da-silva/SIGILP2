package br.ufrn.imd.Controllers;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterController {

    private final String jsonFilePath;

    public RegisterController(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }

    // Método para carregar o arquivo JSON
    public JSONArray loadJsonFile() {
        try (FileReader reader = new FileReader(jsonFilePath)) {
            StringBuilder jsonContent = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                jsonContent.append((char) i);
            }
            return new JSONArray(jsonContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONArray(); // Retorna um array vazio em caso de erro
        }
    }

    // Método para salvar o arquivo JSON
    public void saveJsonFile(JSONArray jsonArray) {
        try (FileWriter file = new FileWriter(jsonFilePath)) {
            file.write(jsonArray.toString(4)); // Formatação com indentação
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para adicionar um novo usuário ao JSON
    public void addUser(JSONObject newUser) {
        JSONArray jsonArray = loadJsonFile();
        jsonArray.put(newUser);
        saveJsonFile(jsonArray);
    }

    public boolean isCpfRegistered(String cpf) {
        JSONArray jsonArray = loadJsonFile();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject user = jsonArray.getJSONObject(i);
            if (user.has("cpf") && user.getString("cpf").equals(cpf)) {
                return true; // CPF já registrado
            }
        }
        return false; // CPF não registrado
    }

    public boolean isMailRegistered(String email) {
        JSONArray jsonArray = loadJsonFile();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject user = jsonArray.getJSONObject(i);
            if (user.has("email") && user.getString("email").equals(email)) {
                return true; // E-mail já registrado
            }
        }
        return false; // E-mail não registrado
    }
}
