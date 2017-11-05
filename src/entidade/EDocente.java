package entidade;

import util.Titulacao;

/**
 *
 * @author gguui
 */
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
    
    @Override
    public String toString() {
        return "EDocente{" 
                + "matricula=" + matricula
                + ", CPF=" + CPF 
                + ", nome=" + nome 
                + ", dataNascimento=" + dataNascimento 
                + ", telefone=" + telefone 
                + ", celular=" + celular 
                + ", email=" + email 
                + ", endereco=" + endereco
                + ", sexo=" + sexo 
                + ", titulacao=" + titulacao
                + ", disciplina=" + disciplina
                + '}';
    }
}