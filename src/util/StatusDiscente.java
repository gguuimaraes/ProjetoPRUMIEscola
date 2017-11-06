package util;

public enum StatusDiscente {
    ATIVO(1, "Ativo"),
    INATIVO(2, "Inativo");
    
    private final int id;
    private final String nome;

    StatusDiscente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
    
    public String toString() {
        return nome;
    } 
    
    public static StatusDiscente valueOf(int id) {
        switch(id) {
            case 1: return ATIVO;
            default: return INATIVO;
        }
    }
}
