/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EDiscente;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PDiscente;

/**
 *
 * @author Pedro
 */
public class NDiscente {
     PDiscente discente;

    public NDiscente() {
        discente = new PDiscente();
    }

    public void salvar(EDiscente dis) throws SQLException, Exception {
        if (dis.getMatricula() == 0) {
            discente.incluir(dis);
        } else {
            discente.alterar(dis);
        }
    }

    public void excluir(int codigo) throws SQLException, Exception {
        discente.excluir(codigo);
    }

    public EDiscente consultar(int codigo) throws SQLException, Exception {
        return discente.consultar(codigo);
    }

    public ArrayList<EDiscente> listar() throws SQLException, Exception {
        return discente.listar();
    }
}

