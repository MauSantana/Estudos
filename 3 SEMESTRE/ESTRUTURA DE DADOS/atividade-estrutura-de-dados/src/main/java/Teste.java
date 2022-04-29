public class Teste {
    public static void main(String[] args) {
        ListaObj<Produto> lista = new ListaObj<>(5);
        Produto p1 = new Produto(12, "Notebook", 5.000, "*****", 2);
        Produto p2 = new Produto(13, "Livro", 50.0, "***", 3);
        Produto p3 = new Produto(14, "Caneta", 2.0, "***", 8);
        Produto p4 = new Produto(15, "Iphone", 8.000, "***", 9);
        Produto p5 = new Produto(16, "Xiaomi", 3.000, "**", 1);

        p1.compra(3);
        p2.compra(8);
        p3.compra(7);
        p4.compra(22);
        p5.compra(17);

        lista.adiciona(p1);
        lista.adiciona(p2);
        lista.adiciona(p3);
        lista.adiciona(p4);
        lista.adiciona(p5);

        System.out.printf("--------------------------------------------------------------------\n");

        System.out.printf("%-6s  %-14s  %-7s  %7s %14s \n","Código:","Nome:","Preço:","Nota:","Faturamento:");

        lista.exibe();

        System.out.printf("--------------------------\n");

    }
}