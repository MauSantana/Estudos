
package br.com.bandtec.projeto2.nivelamento;

/*
*
* @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
*/

public class Programa4 {

    public static void main(String[] args) {

        /*
            Operadores de comparação são os mesmos utilizados no javascript,
            são eles:
                >  maior
                <  menor
                == igual
                != diferente de
                <= menor igual
                >= maior igual
         */
        Integer num1 = 10;

        // exemplo de if / else
        if (num1 > 10) {
            System.out.println("É maior");
        } else {
            System.out.println("É menor");
        }

        // Exemplo de if / else if / else
        if (num1 > 10) {
            System.out.println("É maior");
        } else if (num1 == 10) {
            System.out.println("É igual");
        } else {
            System.out.println("É menor");
        }

        /*
            SEMPRE que comparamos textos em Java 
            devemos utilizar o ".equals()".
            
            .toLowerCase() -> garante que o texto será formatado para caixa baixa.
            .toUpperCase() -> garante que o texto será formatado para caixa alta.
            equalsIgnoreCase() -> desconsidera formatação e compara o valor.
         */
        String nome = "Diego";
        String nome2 = "diego";

        if (nome.equals(nome2)) {
            System.out.println("Está correto");
        }

        /* 
            Podemos utilizar o ".equals" também para comparar números.
         */
        if (num1.equals(10)) {
            System.out.println("É o mesmo número");
        }

        Integer idade = 27;

        // Exemplo do operador "diferente de"
        if (idade != 27) {
            System.out.println("Idade diferente");
        }

        /* 
            Operadores lógicos "and" / "or" 
            são os mesmos utilizados no Javascript, são eles:
                or -> ||
                and -> &&
         */
      
        // Exemplo and
        if (nome.equals("Diego") && idade.equals(27)) {
            System.out.println("Os dois estão corretos");
        } else {
            System.out.println("algo deu falso");
        }

        // Exemplo or
        if (nome.equals("Brito") || idade.equals(27)) {
            System.out.println("um deles está correto");
        } else {
            System.out.println("ambos deram falsos");
        }
    }
}
