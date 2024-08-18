package br.ufrn.imd.Models;
import java.util.List;

public class Owner {
    private String name;
    private String cpf;
    private boolean logado;
    private String username;
    private String telephone;
    private String cep;
    private String address;
    private String email;
    private String password;
    private List<Contract> contracts ;

    public Owner(String name, String cpf, boolean logado, String username, String telephone, String cep, String address, String email, String password, List<Contract> contracts) {
        this.name = name;
        this.cpf = cpf;
        this.logado = logado;
        this.username = username;
        this.telephone = telephone;
        this.cep = cep;
        this.address = address;
        this.email = email;
        this.password = password;
        this.contracts = contracts;
    }
}
