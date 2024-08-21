package br.ufrn.imd.Dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.ufrn.imd.Exceptions.OwnerNotLoggedException;
import br.ufrn.imd.Models.Contract;
import br.ufrn.imd.Models.Kitnet;
import br.ufrn.imd.Models.Owner;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class FileManager {

    private String pathFile = "src/main/java/br/ufrn/imd/Files/owners.json";

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    /**
     * Salva ou atualiza um proprietário (Owner) no arquivo "owners.json".
     *
     * Este método adiciona um proprietário à lista de proprietários no arquivo JSON ou atualiza as informações de um
     * proprietário existente com o mesmo CPF. Se o arquivo não existir, ele será criado. Em caso de falha na gravação,
     * uma exceção será lançada.
     *
     * @param owner O objeto `Owner` a ser salvo ou atualizado no arquivo.
     * @throws IOException Se ocorrer um erro ao tentar salvar o arquivo.
     */
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

    /**
     * Lê e retorna a lista de todos os proprietários (Owners) do arquivo "owners.json".
     *
     * Este método lê um arquivo JSON contendo uma lista de proprietários e retorna essa lista como uma `List<Owner>`.
     * Se o arquivo não existir, ele será criado e uma lista vazia será retornada. Em caso de erro de leitura ou sintaxe,
     * uma lista vazia será retornada e a exceção será tratada.
     *
     * @return Uma `List<Owner>` contendo todos os proprietários lidos do arquivo JSON, ou uma lista vazia se o arquivo não existir ou houver erros na leitura.
     * @throws IOException Se ocorrer um erro ao tentar ler o arquivo.
     */
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

    /**
     * Retorna o proprietário correspondente ao CPF fornecido, se estiver logado.
     *
     * Este método percorre a lista de todos os proprietários e retorna o proprietário cujo CPF corresponde ao CPF fornecido,
     * desde que o proprietário esteja logado. Se nenhum proprietário com o CPF fornecido estiver logado, o método retorna `null`.
     *
     * @param cpf O CPF do proprietário que se deseja buscar.
     * @return A instância de `Owner` correspondente ao CPF fornecido e que está logado, ou `null` se não houver correspondência ou se o proprietário não estiver logado.
     * @throws IOException Se ocorrer um erro ao ler a lista de todos os proprietários.
     */
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


    /**
     * Retorna o proprietário que está atualmente logado.
     *
     * Este método percorre a lista de todos os proprietários e retorna o primeiro que estiver marcado como logado.
     * Se nenhum proprietário estiver logado, o método retorna `null`.
     *
     * @return A instância de `Owner` correspondente ao proprietário logado, ou `null` se nenhum proprietário estiver logado.
     * @throws IOException Se ocorrer um erro ao ler a lista de todos os proprietários.
     */
    public Owner readOwnerLogged() throws IOException, OwnerNotLoggedException {
        List<Owner> owners = readAllOwners();
        if (owners != null) {
            for (Owner owner : owners) {
                if (owner.isLogged()) {
                    return owner;
                }
            }
        }
        throw new OwnerNotLoggedException("Nenhum proprietário está logado.");
    }


    /**
     * Salva uma nova kitnet na lista de kitnets associadas ao proprietário logado.
     *
     * Este método adiciona uma nova instância de `Kitnet` à lista de kitnets do proprietário logado
     * e, em seguida, salva o estado atualizado do proprietário.
     *
     * @param kitnet A instância de `Kitnet` a ser salva.
     * @return `true` se a kitnet for salva com sucesso.
     * @throws RuntimeException Se ocorrer um erro durante a leitura dos dados do proprietário logado ou ao salvar o proprietário.
     */
    public boolean saveKitnet(Kitnet kitnet) {
        Owner owners = new Owner();
        try {
            owners = readOwnerLogged();
            owners.getKitnets().add(kitnet);
            saveOwner(owners);
        } catch (IOException | OwnerNotLoggedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    /**
     * Verifica se uma kitnet específica existe na lista de kitnets associadas ao proprietário logado.
     *
     * Este método percorre a lista de kitnets do proprietário logado para verificar se uma kitnet
     * com o número especificado (`nKitnet`) está presente. Se encontrar, retorna `true`; caso contrário, retorna `false`.
     *
     * @param nKitnetUUID O número da kitnet a ser verificado.
     * @return `true` se a kitnet com o número especificado existir; `false` caso contrário.
     * @throws RuntimeException Se ocorrer um erro de leitura dos dados do proprietário logado.
     */
    public boolean kitnetExists(UUID nKitnetUUID){
        Owner owners = new Owner();

        try {
            owners = readOwnerLogged();
            for(Kitnet k: owners.getKitnets()){
                if(k.getnKitnetUUID().compareTo(nKitnetUUID) == 0){
                    return true;
                }
            }
            return false;
        } catch (IOException | OwnerNotLoggedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Remove uma kitnet específica da lista de kitnets associadas ao proprietário logado.
     *
     * Este método remove uma kitnet com base no número da kitnet (`nKitnet`). Dependendo do valor de `edit`,
     * ele removerá a kitnet independentemente do número do contrato ou apenas removerá aquelas
     * que não têm um contrato associado (`nContract == -1`). Após a remoção, as alterações são salvas.
     *
     * @param nKitnetUUID O número da kitnet a ser removida.
     * @return `true` se a kitnet foi removida com sucesso; `false` caso contrário.
     * @throws RuntimeException Se ocorrer um erro de leitura ou gravação dos dados do proprietário logado.
     */
    public boolean removeKitnet(UUID nKitnetUUID) {

        boolean removed = false;
        try {
            Owner owners = readOwnerLogged();

            removed = owners.getKitnets().removeIf(k -> k.getnKitnetUUID().compareTo(nKitnetUUID) == 0);

            if (removed) {
                saveOwner(owners);
                return true;
            } else {
                return false;
            }
        } catch (IOException | OwnerNotLoggedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Busca uma kitnet específica associada ao proprietário atualmente logado.
     *
     * Este método busca uma kitnet no sistema com base no número da kitnet (`nKitnet`).
     * Ele primeiro carrega o proprietário logado e, em seguida, percorre a lista de kitnets
     * associadas a esse proprietário para encontrar a kitnet correspondente ao número fornecido.
     * Se a kitnet for encontrada, ela é retornada; caso contrário, o método retorna `null`.
     *
     * @param nKitnetUUID O número da kitnet a ser buscado.
     * @return A instância da classe `Kitnet` correspondente ao número da kitnet, se encontrada;
     *         `null` se a kitnet não for encontrada.
     * @throws RuntimeException Se ocorrer um erro de leitura do proprietário logado.
     */
    public Kitnet searchKitnet(UUID nKitnetUUID){
        Owner owners = new Owner();

        try {
            owners = readOwnerLogged();
            for(Kitnet k: owners.getKitnets()){
                if(k.getnKitnetUUID().compareTo(nKitnetUUID) == 0){
                    return k;
                }
            }
            return null;
        } catch (IOException | OwnerNotLoggedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Edita uma kitnet existente no sistema.
     *
     * Este método tenta remover a kitnet existente, identificada pelo número da kitnet (nKitnet),
     * e então salva a nova versão da kitnet fornecida como argumento. Se ambos os passos forem bem-sucedidos,
     * a edição é considerada bem-sucedida e o método retorna `true`. Caso contrário, o método retorna `false`.
     *
     * @param kitnet A instância da classe `Kitnet` que contém os dados atualizados da kitnet a ser editada.
     * @return `true` se a kitnet foi editada e salva com sucesso; `false` caso contrário.
     */
    public boolean editKitnet(Kitnet kitnet){
        if(removeKitnet(kitnet.getnKitnetUUID())){
            if (saveKitnet(kitnet)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public List<Kitnet> searchKitchenettes(){
        Owner owners = new Owner();
        List<Kitnet> kitchenettes = new ArrayList<>();

        try {
            Owner ownerLogged = readOwnerLogged();
            if (ownerLogged != null) {
                kitchenettes = ownerLogged.getKitnets();
            }
            return kitchenettes;
        } catch (IOException | OwnerNotLoggedException e) {
            System.out.println("Erro ao extrair lista de kitnets");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
