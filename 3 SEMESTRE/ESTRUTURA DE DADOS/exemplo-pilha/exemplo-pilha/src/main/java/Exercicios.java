public class Exercicios {

    public static Boolean ehPalindromo(int[] vetor) {
        Pilha pilha = new Pilha(vetor.length);


        for (int i = 0; i < vetor.length; i++) {
            pilha.push(vetor[i]);
        }

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != pilha.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void converteParaBinario(int num) {
        Pilha pilha = new Pilha((int) (Math.log(num) / Math.log(2))+1);
        int numOriginal = num;

        while (num != 0) {
            pilha.push(num % 2);
            num /= 2;           // ou num = num / 2;
        }

        System.out.print(numOriginal + " em binário é ");
        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop());
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] vetor1 = {1, 3, 3, 1};
        int[] vetor2 = {10, 20, 30, 40};
        int[] vetor3 = {1, 2, 3, 2, 1};

        System.out.println("vetor1 é palíndromo ? " + ehPalindromo(vetor1));
        System.out.println("vetor2 é palíndromo ? " + ehPalindromo(vetor2));
        System.out.println("vetor3 é palíndromo ? " + ehPalindromo(vetor3));

        converteParaBinario(12);
        converteParaBinario(8);
        converteParaBinario(1024);
        converteParaBinario(15);

        PilhaObj<String> pilha = new PilhaObj(5);
        pilha.push("A");
        pilha.push("B");
        pilha.push("C");
        pilha.push("D");
        pilha.push("E");
        pilha.push("F");

        pilha.exibe();

        System.out.println("Desempilhou: " + pilha.pop());
        System.out.println("Topo da pilha: " + pilha.peek());
        pilha.exibe();

        while(!pilha.isEmpty()) {
            System.out.println("Desempilhou: " + pilha.pop());
        }

    }
}
