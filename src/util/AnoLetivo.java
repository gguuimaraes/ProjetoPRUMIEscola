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
    
    public static AnoLetivo valueOf(int id) {
        switch(id) {
            case 1: return F1;
            case 2: return F2;
            case 3: return F3;
            case 4: return F4;
            case 5: return F5;
            case 6: return F6;
            case 7: return F7;
            case 8: return F8;
            case 9: return F9;
            case 10: return M1;
            case 11: return M2;
            default: return M3;
        }
    }
}
