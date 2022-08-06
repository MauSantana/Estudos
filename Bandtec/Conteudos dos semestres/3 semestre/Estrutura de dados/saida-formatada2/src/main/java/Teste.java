public class Teste {
    public static void main(String[] args) {
        ListaObj<Produto> lista = new ListaObj<>(5);
        Produto p1 = new Produto(12033, "MacM1", 12.000, "*", 5);
        Produto p2 = new Produto(12034, "Iphone 13", 7.000, "****", 30);
        Produto p3 = new Produto(12035, "Ipad", 23.000, "****", 16);
        Produto p4 = new Produto(12036, "AppleWatch", 4.000, "*****", 9);
        Produto p5 = new Produto(12037, "Iphone SE", 3.800, "**", 2);



        p1.comprar(5);
        p2.comprar(30);
        p3.comprar(40);
        p4.comprar(4);
        p5.comprar(2);



        lista.adicionar(p1);
        lista.adicionar(p2);
        lista.adicionar(p3);
        lista.adicionar(p4);
        lista.adicionar(p5);

        System.out.printf("--------------------------------------------------------------------\n");
        System.out.printf("%-6s  %-14s  %-7s  %7s %14s \n","CODIGO","NOME","PREÇO","NOTA","FATURAMENTO");

        lista.exibe();
        System.out.printf("--------------------------------------------------------------------\n");

    }
}
