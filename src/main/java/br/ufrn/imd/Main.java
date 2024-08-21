package br.ufrn.imd;

import br.ufrn.imd.Views.ContractsPage;

import javax.swing.*;
import br.ufrn.imd.Views.LoginForm;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new LoginForm().setVisible(true);
            }
        });
    }
}

/*package br.ufrn.imd;

import br.ufrn.imd.Dao.FileManager;
import br.ufrn.imd.Enums.FilePath;
import br.ufrn.imd.Models.Contract;
import br.ufrn.imd.Models.Kitnet;
import br.ufrn.imd.Models.Owner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Definindo o caminho do arquivo dentro do pacote
        String filePath = "src/main/java/br/ufrn/imd/Files/owners.json";

        // Usando o caminho do arquivo no FileManager
        FileManager fileManager = new FileManager();
        fileManager.setPathFile(filePath);

        // Criando objetos de teste usando construtores
        Kitnet kitnet = new Kitnet(1, "mobiliado", "Luiz", "novo", "59086-340", "rn", "Natal", "Rua sei lá");

        Contract contract = new Contract(1, "Luiz", "luiz@gmail.com", "40028922", kitnet, new Date(), new Date(), 500.0, 1.0, "ativo");

        List<Contract> contracts = new ArrayList<>();
        contracts.add(contract);

        Owner owner = new Owner("Luiz", "01699171424", true, "Luiz", "40028922", "59086-340", "Rua sei lá", "luiz@gmail.com", "123", contracts);
        Owner owner2 = new Owner("Luiz", "01699171425", true, "Luiz", "40028922", "59086-340", "Rua sei lá", "luiz@gmail.com", "123", contracts);
        Owner owner3 = new Owner("Luiz", "01699171426", true, "Luiz", "40028922", "59086-340", "Rua sei lá", "luiz@gmail.com", "123", contracts);

        // Salvando dados
        try {
            fileManager.saveOwner(owner);
            fileManager.saveOwner(owner2);
            fileManager.saveOwner(owner3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lendo dados
        try {
            Owner readOwner = fileManager.readOwner("01699171424");
            System.out.println(readOwner.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/
