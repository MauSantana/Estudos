public class Teste {
    public static void main(String[] args) {

        Fila fila = new Fila(5);

        fila.insert("L");
        fila.insert("U");
        fila.insert("A");
        fila.insert("N");
        fila.insert("N");

        System.out.println("O primeiro é: " + fila.peek());

        System.out.println("\n Removendo:");
        System.out.println(fila.poll());
        System.out.println(fila.poll());
        System.out.println(fila.poll());
        System.out.println(fila.poll());
        System.out.println(fila.poll());

        fila.exibe();
    }
}
