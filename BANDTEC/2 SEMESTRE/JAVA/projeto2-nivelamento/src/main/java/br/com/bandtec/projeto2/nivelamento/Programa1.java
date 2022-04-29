
package br.com.bandtec.projeto2.nivelamento;

/*
*
* @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
*/

public class Programa1 {
    public static void main(String[] args) {
    
        // Java utiliza tipagem ESTÁTICA
        // Javascript utiliza tipagem DINÂMICA
        
        // Variáveis alfanuméricas (texto)
        String nome = "Diego";
        String cidade = "São Paulo";
        String trabalha = "Bandtec";
        
        // Variáveis para números inteiros -> Integer    
        Integer idade = 27;
        Integer nascimento = 1993;
        
        // Varaiáveis para números reais -> Double
        Double preco = 4.40;
        Double temperatura = 22.2;
        
        // Variáveis lógicas ou booleanas -> Boolean
        Boolean ligado = true;
        Boolean professor = true;
        Boolean temMundial = false;
        
        // Convertendo texto em inteiro
        // Utilizamos o "valueOf"
        String numeroInteiroTxt = "25";
        
        Integer numeroInteiroConvertido = Integer.valueOf(numeroInteiroTxt);
        
        // Convertendo texto em numero real
        String numeroRealTxt = "25.60";
        
        Double numeroRealConvertido = Double.valueOf(numeroRealTxt);
    }
}
