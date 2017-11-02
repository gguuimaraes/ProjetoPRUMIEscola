package util;

public enum StatusTurma {
    ABERTA(1, "Aberta"),
    FECHADA(2, "Fechada");
    
    private final int id;
    private final String nome;

    StatusTurma(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
    
    public String toString() {
        return nome;
    } 
}
