package util;

public enum Titulacao {
    TECNOLOGO(1, "Tecnólogo"),
    BACHARELADO(2, "Bacharelado"),
    LICENCIATURA(3, "Licenciatura"),
    ESPECIALIZACAO(4, "Especialização"),
    MESTRADO(5, "Mestrado"),
    DOUTORADO(6, "Doutorado");
    
    private final int id;
    private final String nome;

    Titulacao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
    
    public String toString() {
        return nome;
    }
    
    public static Titulacao valueOf(int id) {
        switch(id) {
            case 1: return TECNOLOGO;
            case 2: return BACHARELADO;
            case 3: return LICENCIATURA;
            case 4: return ESPECIALIZACAO;
            case 5: return MESTRADO;
            default: return DOUTORADO;
        }
    }
}
