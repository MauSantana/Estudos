
package br.com.bandtec.lista05.clube.calculadora;


public class Calculadora {
    private Double num1;
    private Double num2;

    public Double getNum1() {
        return num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }
    
    public void realizarSoma(Double numero1 , Double numero2){
        Double resultadoSomar;
        resultadoSomar = numero1 + numero2;
        System.out.println(String.format("%.1f + %.1f = %.1f \n"
                , numero1,numero2, resultadoSomar));  
    }
    public void realizarSubtracao(Double numero1 , Double numero2){
        Double resultadoSubtrair;
        resultadoSubtrair = numero1 - numero2;
        System.out.println(String.format("%.1f - %.1f = %.1f \n"
                , numero1,numero2, resultadoSubtrair));  
    }
    public void realizarMultiplicacao(Double numero1 , Double numero2){
        Double resultadoMultiplicar;
        resultadoMultiplicar = numero1 * numero2;
        System.out.println(String.format("%.1f * %.1f = %.1f \n"
                , numero1,numero2, resultadoMultiplicar));   
    }
    public void realizarDivisao(Double numero1 , Double numero2){
        Double resultadoDivisao = numero1 / numero2;         
        System.out.println(String.format("%.1f / %.1f = %.1f \n"
                , numero1,numero2, resultadoDivisao));
        

    }
//    @Override
//    public String toString() {
//        return "Calculadora{" + "num1=" + num1 + ", num2=" + num2 + ", resultado=" + resultado + '}';
//    }
    
}
