import java.util.Scanner;

public class TesteDinamico {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNL = new Scanner(System.in);

        Integer codigo, quantVitamina, opcao;
        String descricao, fragrancia;
        Double preco;
        Boolean fim = false;

        Tributo trib = new Tributo();

        while (!fim) {
            System.out.println("Escolha uma opção");
            System.out.println("1- Adicionar alimento");
            System.out.println("2- Adicionar perfume");
            System.out.println("3- Adicionar serviço");
            System.out.println("4- Exibir todos os itens da lista");
            System.out.println("5- Exibir o total de tributos");
            System.out.println("6- Fim");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:  // Adicionar um alimento
                    System.out.println("Digite o código do alimento");
                    codigo = leitor.nextInt();
                    System.out.println("Digite a descrição do alimento");
                    descricao = leitorNL.nextLine();
                    System.out.println("Digite o preço do alimento");
                    preco = leitor.nextDouble();
                    System.out.println("Digite a quantidade de vitaminas");
                    quantVitamina = leitor.nextInt();
                    Alimento a = new Alimento(codigo, descricao, preco, quantVitamina);
                    trib.adicionaTributavel(a);
                    break;
                case 2:  // Adicionar um perfume
                    System.out.println("Digite o código do perfume");
                    codigo = leitor.nextInt();
                    System.out.println("Digite a descrição do perfume");
                    descricao = leitorNL.nextLine();
                    System.out.println("Digite o preço do perfume");
                    preco = leitor.nextDouble();
                    System.out.println("Digite a fragrância do perfume");
                    fragrancia = leitorNL.nextLine();
                    Perfume p = new Perfume(codigo, descricao, preco, fragrancia);
                    trib.adicionaTributavel(p);
                    break;
                case 3:  // Adicionar um serviço
                    System.out.println("Digite a descrição do serviço");
                    descricao = leitorNL.nextLine();
                    System.out.println("Digite o preço do serviço");
                    preco = leitor.nextDouble();
                    Servico s = new Servico(descricao, preco);
                    trib.adicionaTributavel(s);
                    break;
                case 4: // Exibir todos os itens tributáveis
                    trib.exibirTodos();
                    break;
                case 5: // Exibe o total dos tributos da lista
                    System.out.println(
                       String.format("Total dos tributos: R$ %.2f",
                                      trib.calculaTotalTributo()));
                    break;
                case 6: // Final do programa
                    fim = true;
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente!");
                    break;
            }
        }
    }
}
