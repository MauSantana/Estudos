import java.util.Scanner;

public class TesteListaAluno {
    public static void main(String[] args) {
        Boolean fim = false;
        String ra;
        String nome;
        Double nota ;

        Scanner leitor = new Scanner(System.in);
        Scanner leitorDouble = new Scanner(System.in);

        Integer n;

        ListaObj<String> lista = new ListaObj(10);




        do {
            System.out.println("1* Adicionar um Aluno");
            System.out.println("2* Exibir a Lista");
            System.out.println("3* Exibir um Aluno da Lista");
            System.out.println("4* Limpar a Lista");
            System.out.println("5* fim");
            n = leitorDouble.nextInt();
            switch (n){
                case 1:
                    System.out.println("Adicionar o nome do Aluno");
                    nome = leitor.nextLine();
                    System.out.println("Adicione o RA do Aluno");
                    ra = leitor.nextLine();
                    System.out.println("Adicione a Nota de um Aluno");
                    nota = leitorDouble.nextDouble();
                    Aluno aluno1 = new Aluno(ra,nome,nota);
                    lista.adicionar(aluno1);
                    break;
                case 2:
                    System.out.println("Exbir a Lista");
                    lista.exibe();
                    break;
                case 3:
                    System.out.println("Digite o Indice do Aluno");
                    lista.procurar(leitorDouble.nextInt());

                    break;
                case 4:
                    System.out.println("limpa a lista");
                    lista.limpar();
                    break;
                case 5:
                    System.out.println("Fim");
                    fim = true;
            }
        } while (!fim);


    }
}
