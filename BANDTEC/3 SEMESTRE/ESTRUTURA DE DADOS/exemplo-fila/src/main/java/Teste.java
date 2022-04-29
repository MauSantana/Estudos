public class Teste {
    public static void main(String[] args) {

        Fila fila = new Fila(8);

        fila.exibe();

        System.out.println("---------------------");

        fila.insert("Barça");
        fila.insert("São Caetano");
        fila.insert("Real Madrid");
        fila.insert("Santos");
        fila.insert("Grêmio");
        fila.insert("Palmeiras");

        System.out.println("---------------------");

        // Trazendo o primeiro da fila
        System.out.println("Primeiro da fila: " + fila.peek());

        System.out.println("---------------------");

        fila.exibe();

        System.out.println("---------------------");

        fila.poll();





    }
}
