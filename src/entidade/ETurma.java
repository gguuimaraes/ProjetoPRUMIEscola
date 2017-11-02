package entidade;

import util.AnoLetivo;
import util.StatusTurma;

public class ETurma {
    private int codigo;
    private AnoLetivo anoLetivo;
    private char letra;
    private String anoAtual;
    private int numeroVagas;
    private StatusTurma status;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public AnoLetivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLetivo anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public String getAnoAtual() {
        return anoAtual;
    }

    public void setAnoAtual(String anoAtual) {
        this.anoAtual = anoAtual;
    }

    public int getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(int numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    public StatusTurma getStatus() {
        return status;
    }

    public void setStatus(StatusTurma status) {
        this.status = status;
    }
    
    
}
