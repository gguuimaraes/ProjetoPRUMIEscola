/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EDocente;
import java.sql.SQLException;
import java.util.List;
import persistencia.PDocente;

/**
 *
 * @author Pedro
 */
public class NDocente {

    PDocente pDocente;

    public NDocente() {
        pDocente = new PDocente();
    }

    public void salvar(EDocente doce) throws SQLException, Exception {
        if (doce.getMatricula() == 0) {
            pDocente.incluir(doce);
        } else {
            pDocente.alterar(doce);
        }
    }

    public void excluir(int codigo) throws SQLException, Exception {
        pDocente.excluir(codigo);
    }

    public EDocente consultar(int codigo) throws SQLException, Exception {
        return pDocente.consultar(codigo);
    }

    public List<EDocente> listar() throws SQLException, Exception {
        return pDocente.listar();
    }
}
