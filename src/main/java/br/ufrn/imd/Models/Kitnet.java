package br.ufrn.imd.Models;

import br.ufrn.imd.Dao.GenericDAO;

public class Kitnet {
    public int nKitnet;
    public String mobilia;
    public String nomeInquilino;
    public String estadoUso;
    public String cep;
    public String estado;
    public String cidade;
    public String esdereco;

    public Kitnet(int nKitnet, String mobilia, String nomeInquilino, String estadoUso, String cep, String estado, String cidade, String esdereco) {
        this.nKitnet = nKitnet;
        this.mobilia = mobilia;
        this.nomeInquilino = nomeInquilino;
        this.estadoUso = estadoUso;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.esdereco = esdereco;
    }

    public Number getnKitnet() {
        return nKitnet;
    }

    public void setnKitnet(int nKitnet) {
        this.nKitnet = nKitnet;
    }

    public String getMobilia() {
        return mobilia;
    }

    public void setMobilia(String mobilia) {
        this.mobilia = mobilia;
    }

    public String getNomeInquilino() {
        return nomeInquilino;
    }

    public void setNomeInquilino(String nomeInquilino) {
        this.nomeInquilino = nomeInquilino;
    }

    public String getEstadoUso() {
        return estadoUso;
    }

    public void setEstadoUso(String estadoUso) {
        this.estadoUso = estadoUso;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEsdereco() {
        return esdereco;
    }

    public void setEsdereco(String esdereco) {
        this.esdereco = esdereco;
    }

    public void cadastrarKitnet(Kitnet kitnet){
        GenericDAO<Kitnet> kitnetGenericDAO = new GenericDAO<Kitnet>();
        // Esses caminhos podem ser enums!!!
        kitnetGenericDAO.setCaminhoArquivo("C:\\Users\\luizg\\OneDrive\\Documentos\\SIGILP2\\src\\main\\java\\br\\ufrn\\imd\\Files\\kitnets.txt");
        kitnetGenericDAO.cadastrarKitnet(kitnet);
    }

    @Override
    public String toString() {
        return "nKitnet:" + nKitnet +
                ", mobilia:" + mobilia +
                ", nomeInquilino:" + nomeInquilino +
                ", estadoUso:" + estadoUso +
                ", cep:" + cep +
                ", estado:" + estado +
                ", cidade:" + cidade +
                ", esdereco:" + esdereco;
    }
}
