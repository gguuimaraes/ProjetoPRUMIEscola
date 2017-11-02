package entidade;

public class EDocenteTurma {
    private int codigo;
    private EDocente docente;
    private ETurma turma;
    private int cargaHoraria;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public EDocente getDocente() {
        return docente;
    }

    public void setDocente(EDocente docente) {
        this.docente = docente;
    }

    public ETurma getTurma() {
        return turma;
    }

    public void setTurma(ETurma turma) {
        this.turma = turma;
    }
    
    
}
