
import entidade.EDisciplina;
import entidade.EDocente;
import persistencia.PDisciplina;
import persistencia.PDocente;
import util.Sexo;
import util.Titulacao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gguui
 */
public class Teste {

    public static void main(String[] args) {
        try {
            System.out.println(new PDocente().listar().size());
            new PDocente().excluir(6);
            System.out.println(new PDocente().listar().size());
        } catch (Exception ex) {
            System.err.print(ex);
        }
    }
}
