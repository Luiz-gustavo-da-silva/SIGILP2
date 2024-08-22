package br.ufrn.imd.Enums;

public enum Status {
    ATIVO("ATIVO"),
    CANCELADO("CANCELADO"),
    VENCIDO("VENCIDO"),
    RENOVADO("RENOVADO");

    private final String text;

    Status(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
