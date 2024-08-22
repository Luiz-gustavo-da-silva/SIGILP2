package br.ufrn.imd.Controllers;

import br.ufrn.imd.Dao.FileManager;
import br.ufrn.imd.Models.Owner;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class RegisterController {

    private final FileManager fileManager;

    public RegisterController() {
        this.fileManager = new FileManager();
    }

    // Método para adicionar um novo usuário ao JSON
    public void addUser(Owner newUser) {
        try {
            fileManager.saveOwner(newUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isCpfRegistered(String cpf) {
        try {
            List<Owner> owners = fileManager.readAllOwners();
            if(!(owners==null)) {
                for (Owner owner : owners) {
                    if (owner.getCpf() != null && owner.getCpf().equals(cpf)) {
                        return true; // CPF já registrado
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // CPF não registrado
    }

    public boolean isMailRegistered(String email) {
        try {
            List<Owner> owners = fileManager.readAllOwners();
            if(!(owners==null)) {
                for (Owner owner : owners) {
                    if (owner.getEmail() != null && owner.getEmail().equals(email)) {
                        return true; // E-mail já registrado
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // E-mail não registrado
    }
}
