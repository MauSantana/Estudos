public class Teste {

    public static void main(String[] args) {

        // Não é possível fazer new da classe abstrata
        // Por isso, a linha a seguir dá erro!!!
        // Funcionario f = new Funcionario("12345", "Fulano");

        // Criação de um objeto da classe Engenheiro
        Engenheiro e = new Engenheiro("123456", "Fulano da Silva", 15000.0);

        // Exibição dos dados do objeto engenheiro
        System.out.println(e);

        // Criação de objetos das classes Vendedor e Horista
        Vendedor v = new Vendedor("789012", "Mickey", 20000.0, 0.10);
        Horista h = new Horista("765432", "Pateta", 40, 40.0);

        // Exibição dos dados dos objetos vendedor e horista
        System.out.println(v);
        System.out.println(h);

        // Criação do objeto da classe Empresa
        Empresa bandtec = new Empresa();

        // Adiciona os objetos de Engenheiro, Vendedor e Horista à lista de funcionários
        // do objeto bandtec
        bandtec.adicionaFunc(e);
        bandtec.adicionaFunc(v);
        bandtec.adicionaFunc(h);

        // Exibe todos os funcionários da bandtec
        bandtec.exibeTodos();

        // Exibe o total gasto com salário pela bandtec
        bandtec.exibeTotalSalario();

        // Exibe apenas os funcionários horistas
        bandtec.exibeHoristas();

    }
}
