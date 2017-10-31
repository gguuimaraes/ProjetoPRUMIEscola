package entidades;

import util.ANOLETIVO;

public class EDisciplina {
    private int codigo;
    private String descricao;
    private ANOLETIVO anoLetivo;
    private int cargaHoraria;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ANOLETIVO getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(ANOLETIVO anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
