public class Teste {
    public static void main(String[] args) {

        // Criando o vetor
        Fila fila = new Fila(5);

        fila.exibe();

        System.out.println("-----------/-------------/-----------/--------------/-----------/");

        // Inserindo valores na fila
        fila.insert("Corinthians");
        fila.insert("São Paulo");
        fila.insert("Atlético Mineiro");
        fila.insert("Santos");
        fila.insert("Grêmio");
        fila.insert("Palmeiras");

        System.out.println("-----------/-------------/-----------/--------------/-----------/");

        // Trazendo o primeiro da fila
        System.out.println("Primeiro da fila: " + fila.peek());

        System.out.println("-----------/-------------/-----------/--------------/-----------/");

        fila.exibe();

        System.out.println("-----------/-------------/-----------/--------------/-----------/");

        fila.poll();


    }
}
