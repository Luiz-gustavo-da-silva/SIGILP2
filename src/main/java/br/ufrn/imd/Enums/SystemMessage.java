package br.ufrn.imd.Enums;

public enum SystemMessage {
    KITNET_REMOVED_SUCCESS("Kitnet removida com sucesso!"),
    KITNET_REMOVE_ERROR("Não foi possível remover a kitnet. Por favor, tente novamente!"),
    KITNET_REGISTER_SUCCESS("Kitnet cadastrada com sucesso!"),
    KITNET_REGISTER_ERROR("Ocorreu um erro durante o cadastro da kitnet. Tente novamente!"),
    KITNET_EXISTS("Já existe uma kitnet com esse número. Por favor, tente novamente!"),
    KITNET_UPDATE_SUCCESS("Kitnet atualizada com sucesso!"),
    KITNET_UPDATE_ERROR("Não foi possível atualizar a kitnet. Tente novamente."),
    KITNET_NOT_FOUND("Kitnet não encontrada.");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
