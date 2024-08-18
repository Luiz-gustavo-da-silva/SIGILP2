package br.ufrn.imd.Enums;

public enum FilePath {
    OWNERS("src/main/java/br/ufrn/imd/Files/owners.json");

    private final String path;

    FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
