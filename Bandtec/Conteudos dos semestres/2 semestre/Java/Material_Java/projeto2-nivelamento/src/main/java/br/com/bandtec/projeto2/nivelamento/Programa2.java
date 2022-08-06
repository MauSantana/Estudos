
package br.com.bandtec.projeto2.nivelamento;

/*
*
* @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
*/

public class Programa2 {

    public static void main(String[] args) {
        
        /*
            Os sinais utilizados em operações aritméticas básicas
            são os mesmos que você ja viu em Javascript, são eles:
                + soma 
                - subtração
                * multiplicação
                / divisão

                Tbm funcionam: ++, --, +=, -=, *= e etc....
        */
        
        String nome = "Chicó";
        Integer passagensDia = 4;
        Double bilheteUnico = 122.90;
        
        // Supondo que a passagem custa 4.40
        Double passagensTotais = bilheteUnico / 4.40;
        
        // Convertendo valor real(com casas decimais) para inteiro
        Integer passagensTotaisInteiro = passagensTotais.intValue();
        
        System.out.println("Passagens totais: " + passagensTotaisInteiro);
        
        // Apresente a qtd de dias que Chicó pode ir e voltar do trabalho
        // sem preocupações
        // "Chicó pode utilzar esse bilhete por x dias"
        
        // Quebra de linha direto no texto "\n"
        // Tabulação ou TAB "\t"
        
        System.out.println(nome+ " poderá usar o bilhete durante:\n" +
                (passagensTotaisInteiro / passagensDia) + " dias");
    }
}
