
package br.com.bandtec.nivelamento.java2;

public class EstruturaDeDecisao {
 
    public static void main(String[] args) {
        
//        Integer numeroTeste = 51;
//        
//        if (numeroTeste < 50) {
//            System.out.println("É menor que 50");
//        }else if (numeroTeste == 50){
//            System.out.println("É igual a 50");
//        }else {
//            System.out.println("É maior que 50");
//        }
//    }

        Boolean ligado = true;
        
        // ! Representa "NOT"
    
//     if (!ligado) {
//            System.out.println("Está ligado");
//        }else {
//            System.out.println("Está desligado");
//        }

    Integer num1 = 1;
    Integer num2 = 2;
    String nome = "Mauricio";
    String nome2 = "mauricio";
    
    //NÃO COMPARAR TEXTOS UTILIZANDO == !=
    
//        if (nome.equals(nome2)) {
//            System.out.println("É igual");
//        }else{
//            System.out.println("Não É igual");
//        }
        
//        if (num1.equals(num2)) {
//            System.out.println("É igual");
//        }

    //IgnoreCase é usado para permitir 
    //comparação de texto em caixa alta e caixa baixa
    
//        if (nome.equalsIgnoreCase(nome2)) {
//            System.out.println("É igual");
//        }else{
//            System.out.println("Não É igual");
//        }
        
        if (num1.equals(1) && num2.equals(2)) {
            System.out.println("Deu certo");
        }else {
            System.out.println("Deu errado");
        }
        
    }
}

