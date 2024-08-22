package br.ufrn.imd.Controllers;

import br.ufrn.imd.Dao.FileManager;
import br.ufrn.imd.Models.Kitnet;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Controlador para gerenciar operações relacionadas às Kitnets.
 * Esta classe implementa a interface {@link ControllerUtils} para manipular objetos do tipo {@link Kitnet}.
 */
public class KitnetController implements ControllerUtils<Kitnet> {

    private FileManager fm = new FileManager(); // Gerenciador de arquivos para operações de I/O

    /**
     * Registra uma nova Kitnet no sistema.
     *
     * @param kitnet A Kitnet a ser registrada.
     * @return {@code true} se a Kitnet foi registrada com sucesso, {@code false} caso contrário.
     */
    public boolean registerKitnet(Kitnet kitnet) {
        if (validationKitnet(kitnet)) {
            return fm.saveKitnet(kitnet);
        }
        return false;
    }

    /**
     * Verifica se uma Kitnet com o UUID fornecido existe no sistema.
     *
     * @param nKitnetUUID UUID da Kitnet a ser verificada.
     * @return {@code true} se a Kitnet existir, {@code false} caso contrário.
     */
    public boolean kitnetExists(UUID nKitnetUUID) {
        return fm.kitnetExists(nKitnetUUID);
    }

    /**
     * Recupera todas as Kitnets armazenadas no sistema.
     *
     * @return Uma lista de todas as Kitnets.
     */
    public List<Kitnet> recoverKitchenettes() {
        return fm.searchKitchenettes();
    }

    public List<String> getKitchenettesNames(List<Kitnet> kitnetList) {
        return kitnetList.stream()
                .map(Kitnet::getNameKitnet)
                .collect(Collectors.toList());
    }

    public UUID getKitnetUUID(List<Kitnet> kitnetList, String kitnetName) {
        for (Kitnet kitnet : kitnetList) {
            if (kitnet.getNameKitnet().equals(kitnetName)) {
                return kitnet.getnKitnetUUID();
            }
        }
        return null;
    }

    public String getKitnetName(List<Kitnet> kitnetList, UUID kitnetUUID) {
        for (Kitnet kitnet : kitnetList) {
            if (kitnet.getnKitnetUUID().equals(kitnetUUID)) {
                return kitnet.getNameKitnet();
            }
        }
        return null;
    }

    /**
     * Remove uma Kitnet do sistema com base no UUID fornecido.
     *
     * @param nKitnetUUID UUID da Kitnet a ser removida.
     * @return {@code true} se a Kitnet foi removida com sucesso, {@code false} caso contrário.
     */
    public boolean removeKitnet(UUID nKitnetUUID) {
        return fm.removeKitnet(nKitnetUUID);
    }

    /**
     * Pesquisa uma Kitnet pelo UUID fornecido.
     *
     * @param nKitnetUUID UUID da Kitnet a ser pesquisada.
     * @return A Kitnet correspondente ao UUID fornecido, ou {@code null} se não encontrada.
     */
    public Kitnet searchKitnet(UUID nKitnetUUID) {
        return fm.searchKitnet(nKitnetUUID);
    }

    /**
     * Edita as informações de uma Kitnet existente.
     *
     * @param kitnet A Kitnet com as informações atualizadas.
     * @return {@code true} se a Kitnet foi editada com sucesso, {@code false} caso contrário.
     */
    public boolean editKitnet(Kitnet kitnet) {
        if (validationKitnet(kitnet)) {
            return fm.editKitnet(kitnet);
        }
        return false;
    }

    /**
     * Valida os atributos de uma Kitnet para garantir que todos os campos necessários estejam preenchidos.
     *
     * @param kitnet A Kitnet a ser validada.
     * @return {@code true} se a Kitnet for válida, {@code false} caso contrário.
     */
    public boolean validationKitnet(Kitnet kitnet) {
        return kitnet.getFurniture().length() > 0 &&
                kitnet.getStateOfUse().length() > 0 &&
                kitnet.getCep().length() > 0 &&
                kitnet.getState().length() > 0 &&
                kitnet.getCity().length() > 0 &&
                kitnet.getAddress().length() > 0 &&
                kitnet.getNameKitnet().length() > 0 &&
                kitnet.getnKitnetUUID() != null;
    }

    /**
     * Valida o formato de um CEP.
     *
     * @param cep O CEP a ser validado.
     * @return {@code true} se o CEP for válido, {@code false} caso contrário.
     */
    public static boolean isValidCep(String cep) {
        String cleanedCep = cep.replaceAll("\\D", "");
        return cleanedCep.length() == 8 && cleanedCep.matches("\\d{8}");
    }

    /**
     * Converte uma lista de Kitnets em um array bidimensional para exibição em uma tabela.
     *
     * @param kitnets A lista de Kitnets a ser convertida.
     * @return Um array bidimensional com os dados das Kitnets.
     */
    @Override
    public Object[][] convertListToArray(List<Kitnet> kitnets) {
        Object[][] data = new Object[kitnets.size()][10];

        for (int i = 0; i < kitnets.size(); i++) {
            Kitnet kitnet = kitnets.get(i);
            data[i][0] = kitnet.getNameKitnet();
            data[i][1] = kitnet.getFurniture();
            data[i][2] = kitnet.getStateOfUse();
            data[i][3] = kitnet.getCep();
            data[i][4] = kitnet.getState();
            data[i][5] = kitnet.getCity();
            data[i][6] = kitnet.getAddress();
            data[i][7] = "Editar";
            data[i][8] = "Deletar";
        }
        return data;
    }
}
