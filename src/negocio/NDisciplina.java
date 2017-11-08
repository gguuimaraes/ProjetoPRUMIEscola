/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EDisciplina;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PDisciplina;

/**
 *
 * @author Pedro
 */
public class NDisciplina {

    PDisciplina dis;

    public NDisciplina() {
        dis = new PDisciplina();
    }

    public void salvar(EDisciplina parametro) throws SQLException, Exception {
        if (parametro.getCodigo() == 0) {
            dis.incluir(parametro);
        } else {
            dis.alterar(parametro);
        }
    }

    public void excluir(int codigo) throws SQLException, Exception {
        dis.excluir(codigo);
    }

    public EDisciplina consultar(int codigo) throws SQLException, Exception {
        return dis.consultar(codigo);
    }

    public ArrayList<EDisciplina> listar() throws SQLException, Exception {
        return dis.listar();
    }
}
