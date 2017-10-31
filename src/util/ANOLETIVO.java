package util;

public enum ANOLETIVO {
    F1(1, "1° ANO FUNDAMENTAL"),
    F2(2, "2° ANO FUNDAMENTAL"),
    F3(3, "3° ANO FUNDAMENTAL"),
    F4(4, "4° ANO FUNDAMENTAL"),
    F5(5, "5° ANO FUNDAMENTAL"),
    F6(6, "6° ANO FUNDAMENTAL"),
    F7(7, "7° ANO FUNDAMENTAL"),
    F8(8, "8° ANO FUNDAMENTAL"),
    F9(9, "9° ANO FUNDAMENTAL"),
    M1(10, "1° ANO MÉDIO"),
    M2(11, "2° ANO MÉDIO"),
    M3(12, "3° ANO MÉDIO");
    
    private final int id;
    private final String nome;

    ANOLETIVO(int id, String nome) {
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
