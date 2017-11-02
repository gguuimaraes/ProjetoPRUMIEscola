package entidade;

import util.StatusDiscente;

public class EDiscenteTurma {
    private int codigo;
    private EDiscente discente;
    private ETurma turma;
    private StatusDiscente statusDiscente;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public StatusDiscente getStatusDiscente() {
        return statusDiscente;
    }

    public void setStatusDiscente(StatusDiscente statusDiscente) {
        this.statusDiscente = statusDiscente;
    }

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
    
    
}
