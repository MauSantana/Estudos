import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Boolean acabou = false;
        String ra;
        String nome;
        Double nota ;

        Scanner leitor = new Scanner(System.in);
        Scanner leitorDouble = new Scanner(System.in);

        Integer n;

        ListaObj<String> lista = new ListaObj(10);




        do {
            System.out.println("1. Adicionar um aluno");
            System.out.println("2. Exibir a lista");
            System.out.println("3. Exibir um aluno da lista");
            System.out.println("4. Limpar a lista");
            System.out.println("5. Fim!");
            System.out.println("Escolha uma das opções acima");
            n = leitorDouble.nextInt();
            switch (n){
                case 1:
                    System.out.println("Adicionar o nome do aluno");
                    nome = leitor.nextLine();
                    System.out.println("Adicione o RA do aluno");
                    ra = leitor.nextLine();
                    System.out.println("Adicione a Nota de um aluno");
                    nota = leitorDouble.nextDouble();
                    Aluno aluno1 = new Aluno(ra,nome,nota);
                    lista.adicionar(aluno1);
                    break;
                case 2:
                    System.out.println("Exibir a lista");
                    lista.exibe();
                    break;
                case 3:
                    System.out.println("Digite o indice do aluno");
                    lista.procura(leitorDouble.nextInt());

                    break;
                case 4:
                    System.out.println("limpar a lista");
                    lista.limpar();
                    break;
                case 5:
                    System.out.println("Fim");
                    acabou = true;
            }
        } while (!acabou);
    }
}
