
package exercicio05;

public class TesteColaborador {
    public static void main(String[] args) {
        Colaborador  colab1 = new Colaborador ("Mauricio", "DevJavaPleno", 10000.00);
        Colaborador  colab2 = new Colaborador ("Jasy", "Front", 5000.00);
       
        RecursosHumanos rh = new RecursosHumanos();
        
        System.out.println(colab1);
        System.out.println("-----------");
        System.out.println(colab2);
               
        rh.promoverColaborador(colab1, "DevjavaSenior", 15000.00);
        rh.promoverColaborador(colab2, "Estágio", 2600.00);
        
        rh.reajustarSalario(colab2, 10.5);
        
        System.out.println("-----------");
        System.out.println(colab1);
        System.out.println("-----------");
        System.out.println(colab2);
        
        System.out.println("-----------");
        System.out.println(rh);
        
        
        
        

    }
}
