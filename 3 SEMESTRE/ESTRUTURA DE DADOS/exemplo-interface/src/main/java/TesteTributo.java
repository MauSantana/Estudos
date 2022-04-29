public class TesteTributo {

    public static void main(String[] args) {
        // Criação dos objetos tributáveis
        Alimento coxinha = new Alimento(123, "Coxinha",
                2.50, 5);
        Perfume purovoodoo = new Perfume(456,
                "Perfume da Rochelle", 200.0,
                "Doce");
        Servico pinturaParede = new Servico("Pintura de parede",
                1000.0);
        System.out.println(coxinha);
        System.out.println(purovoodoo);
        System.out.println(pinturaParede);

        // Cria objeto da classe Tributo
        Tributo trib = new Tributo();

        // Adiciona os objetos tributáveis à lista de trib
        trib.adicionaTributavel(coxinha);
        trib.adicionaTributavel(purovoodoo);
        trib.adicionaTributavel(pinturaParede);

        // Exibe todos os itens tributáveis da lista
        trib.exibirTodos();

        // Exibe o total de tributos dos itens da lista
        System.out.println("\nTotal de tributos: " +
                String.format("R$ %.2f",trib.calculaTotalTributo()));
    }
}

