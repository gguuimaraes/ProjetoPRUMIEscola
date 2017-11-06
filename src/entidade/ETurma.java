package entidade;

import java.util.ArrayList;
import util.AnoLetivo;
import util.StatusTurma;

/**
 *
 * @author gguui
 */
public class ETurma {
    private int codigo;
    private AnoLetivo anoLetivo;
    private char letra;
    private String anoAtual;
    private int numeroVagas;
    private StatusTurma status;
    private ArrayList<EDiscente> discentes;
    private ArrayList<EDocente> docentes;

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

    public ArrayList<EDiscente> getDiscentes() {
        return discentes;
    }

    public void setDiscentes(ArrayList<EDiscente> discentes) {
        this.discentes = discentes;
    }

    public ArrayList<EDocente> getDocentes() {
        return docentes;
    }

    public void setDocentes(ArrayList<EDocente> docentes) {
        this.docentes = docentes;
    }

    @Override
    public String toString() {
        return "ETurma{" + "codigo=" + codigo + ", anoLetivo=" + anoLetivo + ", letra=" + letra + ", anoAtual=" + anoAtual + ", numeroVagas=" + numeroVagas + ", status=" + status + '}';
    }
}
