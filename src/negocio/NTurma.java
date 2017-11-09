/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.ETurma;
import java.sql.SQLException;
import java.util.List;
import persistencia.PTurma;

/**
 *
 * @author Pedro
 */
public class NTurma {

    PTurma pTurma;

    public NTurma() {
        pTurma = new PTurma();
    }

    public void salvar(ETurma turma) throws SQLException, Exception {
        if (turma.getCodigo() == 0) {
            pTurma.incluir(turma);
        } else {
            pTurma.alterar(turma);
        }
    }

    public void excluir(int codigo) throws SQLException, Exception {
        pTurma.excluir(codigo);
    }

    public ETurma consultar(int codigo) throws SQLException, Exception {
        return pTurma.consultar(codigo);
    }

    public List<ETurma> listar() throws SQLException, Exception {
        return pTurma.listar();
    }
}
