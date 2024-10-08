package br.ufrn.imd.Models;
import java.util.List;

public class Owner {
    private String name;
    private String cpf;
    private boolean logged;
    private String username;
    private String telephone;
    private String cep;
    private String address;
    private String email;
    private String password;
    private String state;
    private List<Contract> contracts ;
    private List<Kitnet> kitnets;

    public Owner() {
    }

    public Owner(String name, String cpf, boolean logged, String username, String telephone, String cep, String address, String email, String password, String state, List<Contract> contracts, List<Kitnet> kitnets) {
        this.name = name;
        this.cpf = cpf;
        this.logged = logged;
        this.username = username;
        this.telephone = telephone;
        this.cep = cep;
        this.address = address;
        this.email = email;
        this.password = password;
        this.state = state;
        this.contracts = contracts;
        this.kitnets = kitnets;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isLogged() {
        return logged;
    }

    public String getUsername() {
        return username;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCep() {
        return cep;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public List<Kitnet> getKitnets() {
        return kitnets;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}
