package br.ufrn.imd.Models;

import br.ufrn.imd.Dao.KitnetDAO;

public class Kitnet {
    public Number nKitnet;
    public String mobilia;
    public String nomeInquilino;
    public String estadoUso;
    public String cep;
    public String estado;
    public String cidade;
    public String esdereco;

    public Number getnKitnet() {
        return nKitnet;
    }

    public void setnKitnet(Number nKitnet) {
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
        new KitnetDAO().cadastrarKitnet(kitnet);
    }
}
