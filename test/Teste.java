
import entidade.EDiscente;
import persistencia.PDiscente;
import util.Sexo;

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
            EDiscente d = new EDiscente();
            d.setNome("nome do fi");
            d.setNomePai("nome do pai");
            d.setNomeMae("nome da mae");
            d.setDataNascimento("03/09/1998");
            d.setSexo(Sexo.MASCULINO);
            new PDiscente().incluir(d);
            System.out.println(d.getMatricula());
        } catch (Exception ex) {
            System.err.print(ex);
        }
    }
}
