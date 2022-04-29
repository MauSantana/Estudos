
package br.com.bandtec.projeto2.nivelamento;

/*
*
* @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
*/

public class Programa3 {
    
    public static void main(String[] args) {
        
        String nome = "João Grilo";
        Integer idade = 30;
        Double bilheteUnico = 255.6054135465465;
        
        // Exibindo frase no console utilizando a técnica de concatenação
        System.out.println(nome + " tem " + idade + " anos e possui " +
                bilheteUnico + " reais em seu bilhete único.");
        
        /*
            Interpolação de Strings
        
            No Javascript, faziamos:
                ` ${nome} tem ${anos} e possui ${bilheteUnico} reais em BU`
        
            No Java utilizamos o: String.format("texto", args);
        
            Tabela de identificadores:
                %s -> para textos
                %d -> para números inteiros
                %.xf -> para números reais onde x é a quantidade de casas decimais.
        
                Caso tenha mais de uma variável do mesmo tipo na frase, basta repetir.
                
                ATENÇÃO!!!!
                    O parâmetros são inseridos na ordem, preste atenção nos identificadores/marcações.
        */
        
        // Exemplo utilizando interpolação:
        String frase = String.format("%s tem %d anos e possui %.2f reais em BU",
                nome, idade, bilheteUnico);
        
        // Exibindo a frase
        System.out.println(frase);
    }
}
