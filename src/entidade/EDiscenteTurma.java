package entidade;

import util.StatusDiscente;

/**
 *
 * @author gguui
 */
public class EDiscenteTurma {
    private EDiscente discente;
    private ETurma turma;
    private StatusDiscente status;

    public EDiscente getDiscente() {
        return discente;
    }

    public void setDiscente(EDiscente discente) {
        this.discente = discente;
    }

    public ETurma getTurma() {
        return turma;
    }

    public void setTurma(ETurma turma) {
        this.turma = turma;
    }

    public StatusDiscente getStatus() {
        return status;
    }

    public void setStatus(StatusDiscente status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EDiscenteTurma{" + "discente=" + discente + ", turma=" + turma + ", status=" + status + '}';
    }
}
