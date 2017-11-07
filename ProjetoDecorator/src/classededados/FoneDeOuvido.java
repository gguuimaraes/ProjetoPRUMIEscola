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
public class FoneDeOuvido extends Acessorio{

    private Celular celu;

    
    public FoneDeOuvido(Celular parametro) {
        this.celu = parametro; 
    }

    public String getDescricao() {
        return celu.getDescricao() + "Fone de ouvido,";
    }

    @Override
    public double Preço() {
        return 25.00 + celu.Preço();
    }
}
