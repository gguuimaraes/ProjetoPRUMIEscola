/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classededados;

/**
 *
 * @author Pedro
 */
public abstract class Celular {
    String descricao = "Celular";
    
    public String getDescricao(){
        return descricao;
    }
    public abstract double Preço();
    
}
