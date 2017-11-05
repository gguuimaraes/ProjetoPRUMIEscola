package util;

public enum Sexo {
    MASCULINO(1, "Masculino"),
    FEMININO(2, "Feminino");
    
    private final int id;
    private final String nome;

    Sexo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
    
    public String toString() {
        return nome;
    }
    
    public static Sexo valueOf(int id) {
        switch(id) {
            case 1: return MASCULINO;
            default: return FEMININO;
        }
    }
}
