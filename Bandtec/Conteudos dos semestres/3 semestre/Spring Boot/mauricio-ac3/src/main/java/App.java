import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNL = new Scanner(System.in);

        Integer opcao, id, nroJogos, vitorias, golsMarcados;
        String nome, time;
        Double salario;
        Boolean fim = false;


        Repositorio repositorio = new Repositorio();

        while (!fim) {
            System.out.println("Escolha uma opção");
            System.out.println("1-Adicionar objeto a lista");
            System.out.println("2-Exibir lista");
//            System.out.println("3-Alterar gol por id");
            System.out.println("3-Desfazer operações");
            System.out.println("4-Apagar os deletes armazenados");
            System.out.println("5-Exportar arquivo TXT e ler arquivo TXT");
            System.out.println("6-Fim");


            opcao = leitorNL.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o id do Jogador");
                    id = leitorNL.nextInt();
                    System.out.println("Digite o nome do Jogador");
                    nome = leitor.nextLine();
                    System.out.println("Digite o salario do Jogador");
                    salario = leitorNL.nextDouble();
                    System.out.println("Digite a quantidade de jogos do Jogador");
                    nroJogos = leitorNL.nextInt();
                    System.out.println("Digite a quantidade de vitorias do Jogador");
                    vitorias = leitorNL.nextInt();
                    System.out.println("Digite a quantidade de gols do Jogador ");
                    golsMarcados = leitorNL.nextInt();
                    System.out.println("Digite o time do Jogador");
                    time = leitor.nextLine();

                    Jogador jogador = new Jogador (id, nome, salario, nroJogos, vitorias, golsMarcados, time);
                    repositorio.save(jogador);

                    break;

                case 2:
                    repositorio.showAll();

                    break;


//                case 3:
//                    Integer idUp;
//                    Integer idUp2;
//                    System.out.println("Digite o id a ser alterado");
//                    idUp = leitor.nextInt();
//                    System.out.println("Digite o novo n° de gols");
//                    idUp2 = leitor.nextInt();
//                    repositorio.updateById(idUp, idUp2);
//
//                    break;

                case 3:
                    Integer qtdOperacoes;
                    System.out.println("Digite a quantidade que deseja desfazer");
                    qtdOperacoes = leitor.nextInt();
                    repositorio.undo(qtdOperacoes);
                    break;

                case 4:
                    repositorio.flush();

                    break;

                case 5:
                    repositorio.exportTXT();

                    break;

                case 6:
                    fim = true;

                    break;

                default:
                    System.out.println("Opcão invalida, digite novamente!");
                    break;
            }
        }

    }

}
