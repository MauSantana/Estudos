public class Teste {

    public static void main(String[] args) {
        int indRetornado;

        ListaEstatica lista = new ListaEstatica(5);

        lista.exibe();

        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);

        lista.exibe();

        lista.adiciona(40);
        lista.adiciona(50);
        lista.adiciona(60);

        lista.exibe();

        indRetornado = lista.busca(30);
        if (indRetornado == -1) {
            System.out.println("\nElemento 30 não foi encontrado");
        }
        else {
            System.out.println("\nElemento 30 encontrado no índice " + indRetornado);
        }

        indRetornado = lista.busca(100);
        if (indRetornado == -1) {
            System.out.println("\nElemento 100 não foi encontrado");
        }
        else {
            System.out.println("\nElemento 100 encontrado no índice " + indRetornado);
        }

        if (lista.removePeloIndice(4)) {
            System.out.println("\nRemovido elemento do índice 4");
        }
        else {
            System.out.println("\nRemoção inválida");
        }

        lista.exibe();
        if (lista.removePeloIndice(0)) {
            System.out.println("\nRemovido elemento do índice 0");
        }
        else {
            System.out.println("\nRemoção inválida");
        }

        lista.exibe();
        if (lista.removePeloIndice(7)) {
            System.out.println("\nRemovido elemento do índice 7");
        }
        else {
            System.out.println("\nRemoção inválida");
        }

        lista.exibe();

        if (lista.removeElemento(30)) {
            System.out.println("\nRemovido elemento 30");
        }
        else {
            System.out.println("\nRemoção inválida");
        }

        lista.exibe();

        if (lista.removeElemento(55)) {
            System.out.println("\nRemovido elemento 55");
        }
        else {
            System.out.println("\nRemoção inválida");
        }

        lista.exibe();

    }
}
