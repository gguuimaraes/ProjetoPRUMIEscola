/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.ENota;
import java.sql.SQLException;
import java.util.List;
import persistencia.PNota;

/**
 *
 * @author Pedro
 */
public class NNota {

    PNota pNota;

    public NNota() {
        pNota = new PNota();
    }

    public void salvar(ENota nota) throws SQLException, Exception {
        if (nota.getCodigo() == 0) {
            pNota.incluir(nota);
        } else {
            pNota.alterar(nota);
        }
    }

    public void excluir(int codigo) throws SQLException, Exception {
        pNota.excluir(codigo);
    }

    public List<ENota> listarPorTurma(int codigoTurma) throws SQLException, Exception {
        return pNota.listarPorTurma(codigoTurma);
    }
}
