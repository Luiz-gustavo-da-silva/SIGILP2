package br.ufrn.imd.Enums;

public enum FilePaths {
    OWNERPATH("C:\\Users\\luizg\\OneDrive\\Documentos\\SIGILP2\\src\\main\\java\\br\\ufrn\\imd\\Files\\kitnets.txt");

    private final String path;

    FilePaths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
