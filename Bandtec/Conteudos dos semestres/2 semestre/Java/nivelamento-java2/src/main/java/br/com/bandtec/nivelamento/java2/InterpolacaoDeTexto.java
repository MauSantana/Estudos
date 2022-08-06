
package br.com.bandtec.nivelamento.java2;

public class InterpolacaoDeTexto {
    public static void main(String[] args) {
        String nome = "Mauricio";
        String sobrenome = "Santana";
        Integer idade = 19;
        Double preco = 53.23523554;
        
        /*
            %s -> texto
            %d -> numero inteiro
            %.xf -> numeros reais (casas decimais)
            onde x representa o numero de casas decimais desejadas
        */
        
        System.out.println("Meu nome é " + nome + " e tenho " + idade + " anos de idade");
        
        /* 
           \t para dar espeço de tab
           \n para quebrar a linha no código
        */
        System.out.println(String.format("\tNome: %s \n\tIdade: %d", nome, idade));
        
        String nomeCompleto = String.format("%s %s", nome, sobrenome);
        
        System.out.println(nomeCompleto);
        
        String frasePreco = String.format("O preço é R$%.2f", preco);
        
        System.out.println(frasePreco);
    }
}
