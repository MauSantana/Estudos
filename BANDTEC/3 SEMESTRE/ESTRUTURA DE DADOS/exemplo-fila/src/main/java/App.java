public class App {
    public static void main(String[] args) {
        Fila fila = new Fila(5);

        fila.insert("primeiro");
        fila.insert("segundo");
        fila.insert("terceiro");
        fila.insert("quarto");

        System.out.println("Peek");
        System.out.println(fila.peek());

        System.out.println("-------------------");
        System.out.println("exibe");
        fila.exibe();

        System.out.println("-------------------");
        System.out.println("pool");
        fila.pool();

        System.out.println("-------------------");
        System.out.println("exibe apos remover");
        fila.exibe();
    }
}
