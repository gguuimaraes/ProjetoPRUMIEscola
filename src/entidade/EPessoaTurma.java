package entidade;

import util.StatusPessoaTurma;

/**
 *
 * @author gguui
 */
public class EPessoaTurma {
    private EPessoa pessoa;
    private ETurma turma;
    private StatusPessoaTurma status;

    public EPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(EPessoa pessoa) {
        this.pessoa = pessoa;
    }

    public ETurma getTurma() {
        return turma;
    }

    public void setTurma(ETurma turma) {
        this.turma = turma;
    }

    public StatusPessoaTurma getStatus() {
        return status;
    }

    public void setStatus(StatusPessoaTurma status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EPessoaTurma{" + "pessoa=" + pessoa + ", turma=" + turma + ", status=" + status + '}';
    }
}
