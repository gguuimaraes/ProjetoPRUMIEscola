package util;

public enum AnoLetivo {
    F1(1, "1° Ano Fundamental"),
    F2(2, "2° Ano Fundamental"),
    F3(3, "3° Ano Fundamental"),
    F4(4, "4° Ano Fundamental"),
    F5(5, "5° Ano Fundamental"),
    F6(6, "6° Ano Fundamental"),
    F7(7, "7° Ano Fundamental"),
    F8(8, "8° Ano Fundamental"),
    F9(9, "9° Ano Fundamental"),
    M1(10, "1° Ano Médio"),
    M2(11, "2° Ano Médio"),
    M3(12, "3° Ano Médio");
    
    private final int id;
    private final String nome;

    AnoLetivo(int id, String nome) {
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
