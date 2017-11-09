/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EDisciplina;
import java.sql.SQLException;
import java.util.List;
import persistencia.PDisciplina;

/**
 *
 * @author Pedro
 */
public class NDisciplina {

    PDisciplina pDisciplina;

    public NDisciplina() {
        pDisciplina = new PDisciplina();
    }

    public void salvar(EDisciplina parametro) throws SQLException, Exception {
        if (parametro.getCodigo() == 0) {
            pDisciplina.incluir(parametro);
        } else {
            pDisciplina.alterar(parametro);
        }
    }

    public void excluir(int codigo) throws SQLException, Exception {
        pDisciplina.excluir(codigo);
    }

    public EDisciplina consultar(int codigo) throws SQLException, Exception {
        return pDisciplina.consultar(codigo);
    }

    public List<EDisciplina> listar() throws SQLException, Exception {
        return pDisciplina.listar();
    }
}
