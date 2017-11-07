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
public class CarregadorPortatil extends Acessorio {
    private Celular celu;
    
    public CarregadorPortatil(Celular parametro){
        this.celu = parametro;
    }
    public String getDescricao(){
        return celu.getDescricao() + "Carregador Portatil";
    }
    @Override
    public double Preço() {
       return  100.00 + celu.Preço();
    }
}
 