/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EDiscente;
import java.sql.SQLException;
import java.util.List;
import persistencia.PDiscente;

/**
 *
 * @author Pedro
 */
public class NDiscente {

    PDiscente pDiscente;

    public NDiscente() {
        pDiscente = new PDiscente();
    }

    public void salvar(EDiscente dis) throws SQLException, Exception {
        if (dis.getMatricula() == 0) {
            pDiscente.incluir(dis);
        } else {
            pDiscente.alterar(dis);
        }
    }

    public void excluir(int codigo) throws SQLException, Exception {
        pDiscente.excluir(codigo);
    }

    public EDiscente consultar(int codigo) throws SQLException, Exception {
        return pDiscente.consultar(codigo);
    }

    public List<EDiscente> listar() throws SQLException, Exception {
        return pDiscente.listar();
    }
}
