package entidade;

/**
 *
 * @author gguui
 */
public class ENota {
    private int codigo;
    private float bimestre1;
    private float bimestre2;
    private float bimestre3;
    private float bimestre4;
    private float recuperacaoParcial;
    private float recuperacaoFinal;
    private ETurma turma;
    private EDocente docente;
    private EDiscente discente;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getBimestre1() {
        return bimestre1;
    }

    public void setBimestre1(float bimestre1) {
        this.bimestre1 = bimestre1;
    }

    public float getBimestre2() {
        return bimestre2;
    }

    public void setBimestre2(float bimestre2) {
        this.bimestre2 = bimestre2;
    }

    public float getBimestre3() {
        return bimestre3;
    }

    public void setBimestre3(float bimestre3) {
        this.bimestre3 = bimestre3;
    }

    public float getBimestre4() {
        return bimestre4;
    }

    public void setBimestre4(float bimestre4) {
        this.bimestre4 = bimestre4;
    }

    public float getRecuperacaoParcial() {
        return recuperacaoParcial;
    }

    public void setRecuperacaoParcial(float recuperacaoParcial) {
        this.recuperacaoParcial = recuperacaoParcial;
    }

    public float getRecuperacaoFinal() {
        return recuperacaoFinal;
    }

    public void setRecuperacaoFinal(float recuperacaoFinal) {
        this.recuperacaoFinal = recuperacaoFinal;
    }

    public ETurma getTurma() {
        return turma;
    }

    public void setTurma(ETurma turma) {
        this.turma = turma;
    }

    public EDocente getDocente() {
        return docente;
    }

    public void setDocente(EDocente docente) {
        this.docente = docente;
    }

    public EDiscente getDiscente() {
        return discente;
    }

    public void setDiscente(EDiscente discente) {
        this.discente = discente;
    }

    @Override
    public String toString() {
        return "ENota{" + "codigo=" + codigo + ", bimestre1=" + bimestre1 + ", bimestre2=" + bimestre2 + ", bimestre3=" + bimestre3 + ", bimestre4=" + bimestre4 + ", recuperacaoParcial=" + recuperacaoParcial + ", recuperacaoFinal=" + recuperacaoFinal + ", turma=" + turma + ", docente=" + docente + ", discente=" + discente + '}';
    }
}
