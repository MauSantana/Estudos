import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNL = new Scanner(System.in);

        Integer opcao, id, qtdTocada, qtdVendidaParaArtista, qtdPlataformas;
        String nome, genero;
        Double nota;
        Boolean fim = false;
//--------------------------------------------------------------------------------------
        Repositorio repositorio = new Repositorio();

        while (!fim) {
            System.out.println("Escolha uma opção");
            System.out.println("1-Adicionar objeto a lista");
            System.out.println("2-Exibir lista");
            System.out.println("3-Deletar por id");
            System.out.println("4-Desfazer operações");
            System.out.println("5-Armazenar os deletes por id");
            System.out.println("6-Apagar os deletes armazenados");
            System.out.println("7-Exportar arquivo TXT e ler arquivo TXT");
            System.out.println("8-Fim");


            opcao = leitorNL.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o id da Musica");
                    id = leitorNL.nextInt();
                    System.out.println("Digite o nome da Musica");
                    nome = leitor.nextLine();
                    System.out.println("Digite a nota da Musica");
                    nota = leitorNL.nextDouble();
                    System.out.println("Digite a quantidade tocada  da Musica");
                    qtdTocada = leitorNL.nextInt();
                    System.out.println("Digite o genero da Musica");
                    genero = leitor.nextLine();
                    System.out.println("Digite a qtd Vendida Para Artista ");
                    qtdVendidaParaArtista = leitorNL.nextInt();
                    System.out.println("Digite a qtd Plataformas que a musica se encontra ");
                    qtdPlataformas = leitorNL.nextInt();

                    Musicas musica = new Musicas(id, nome, nota, genero, qtdTocada, qtdVendidaParaArtista, qtdPlataformas);
                    repositorio.save(musica);

                    break;

                case 2:
                    repositorio.showAll();

                    break;


                case 3:
                    Integer idDel;
                    System.out.println("Digite o id a ser deletado");
                    idDel = leitor.nextInt();
                    repositorio.deleteById(idDel);


                    break;

                case 4:
                    Integer qtdOperacoes;
                    System.out.println("Digite a quantidade que deseja desfazer");
                    qtdOperacoes = leitor.nextInt();
                    repositorio.undo(qtdOperacoes);
                    break;

                case 5:
                    Integer idDelayDelete;
                    System.out.println("Digite o id que deseja armazenar para poder deletar");
                    idDelayDelete = leitor.nextInt();
                    repositorio.delayDeleteById(idDelayDelete);

                    break;

                case 6:
                    repositorio.flush();

                    break;

                case 7:
                    repositorio.exportTXT();

                    break;

                case 8:
                    fim = true;

                    break;

                default:
                    System.out.println("Opcão invalida, digite novamente!");
                    break;
            }
        }

    }

}
