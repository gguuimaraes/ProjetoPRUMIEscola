package entidade;

import util.Titulacao;

public class EDocente extends EPessoa {
    private Titulacao titulacao;
    private EDisciplina disciplina;

    public Titulacao getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(Titulacao titulacao) {
        this.titulacao = titulacao;
    }

    public EDisciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(EDisciplina disciplina) {
        this.disciplina = disciplina;
    }    
}