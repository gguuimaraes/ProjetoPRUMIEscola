package entidade;

import java.util.List;
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
    private List<EPessoaTurma> discentes;
    private List<EPessoaTurma> docentes;
    
    public ETurma() {
        discentes = new ArrayList();
        docentes = new ArrayList();
    }

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

    public List<EPessoaTurma> getDiscentes() {
        return discentes;
    }

    public void setDiscentes(List<EPessoaTurma> discentes) {
        this.discentes = discentes;
    }

    public List<EPessoaTurma> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<EPessoaTurma> docentes) {
        this.docentes = docentes;
    }

    @Override
    public String toString() {
        return "ETurma{" + "codigo=" + codigo + ", anoLetivo=" + anoLetivo + ", letra=" + letra + ", anoAtual=" + anoAtual + ", numeroVagas=" + numeroVagas + ", status=" + status + '}';
    }
}
