
package classededados;

public class Main {
   public static void main(String [] args){
       Celular celu1 = new Samsumg();
       System.out.println("Marca: SAMSUMG");
       System.out.println("Modelo" + celu1.getDescricao());
       System.out.println("Preço" + celu1.Preço());
       System.out.println("------------------------------------------");
       celu1 = new FoneDeOuvido(celu1);
       System.out.println("Modelo: " + celu1.getDescricao());
       System.out.println("Preço: " + celu1.Preço());
       System.out.println("------------------------------------------");
       
       celu1 = new CarregadorPortatil(celu1);
       System.out.println("Marca: SAMSUMG");
       System.out.println("Modelo" + celu1.getDescricao());
       System.out.println("Preço " + celu1.Preço());
       System.out.println("--------------------------------------------");
       
       Celular celu2 = new Iphone();
       System.out.println("Marca: IPHONE");
       System.out.println("Modelo" + celu2.getDescricao());
       System.out.println("Preço" + celu2.Preço());
   } 
}
