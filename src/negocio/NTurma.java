/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.ETurma;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PTurma;

/**
 *
 * @author Pedro
 */
public class NTurma {

    PTurma turma;

    public NTurma() {
        turma = new PTurma();
    }

    public void salvar(ETurma tur) throws SQLException, Exception {
        if (tur.getCodigo() == 0) {
            turma.incluir(tur);
        } else {
            turma.alterar(tur);
        }
    }

    public void excluir(int codigo) throws SQLException, Exception {
        turma.excluir(codigo);
    }

    public ETurma consultar(int codigo) throws SQLException, Exception {
        return turma.consultar(codigo);
    }

    public ArrayList<ETurma> listar() throws SQLException, Exception {
        return turma.listar();
    }
}
