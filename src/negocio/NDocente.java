/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EDocente;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PDocente;

/**
 *
 * @author Pedro
 */
public class NDocente {

    PDocente docente;

    public NDocente() {
        docente = new PDocente();
    }

    public void salvar(EDocente doce) throws SQLException, Exception {
        if (doce.getMatricula() == 0) {
            docente.incluir(doce);
        } else {
            docente.alterar(doce);
        }
    }

    public void excluir(int codigo) throws SQLException, Exception {
        docente.excluir(codigo);
    }

    public EDocente consultar(int codigo) throws SQLException, Exception {
        return docente.consultar(codigo);
    }

    public ArrayList<EDocente> listar() throws SQLException, Exception {
        return docente.listar();
    }
}
