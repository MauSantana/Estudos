public class App {
    public static void main(String[] args) {
        PilhaObj pilha = new PilhaObj<>(10);
        int vet[] = {10, 20, 30, 40, 50};
        String frase = "Eu amo java";

        String s = new String("Batata");
        String s1 = new String("Arroz");
        String s2 = new String("Carlos");
        String s3 = new String("Joao");

        if(pilha.ehPalindromo(vet)){
            System.out.println("É palin");
        }else{
            System.out.println("Não é polin");
        }

        char[] fraseChar = frase.toCharArray();

        System.out.println("Vetor invertido");
        System.out.println(inverterVetor(fraseChar));

        pilha.push(s);
        pilha.push(s1);
        pilha.push(s2);
        pilha.push(s3);

        pilha.exibe();

        pilha.pop();
        pilha.pop();

        pilha.exibe();


    }

    public static char[] inverterVetor(char vet[]) {
        int temp;
        for (int i = 0; i < vet.length; i++) {
            for (int j = 0; j < i; j++) {
                temp = vet[i];
                vet[i] = vet[j];
                vet[j] = (char) temp;
            }
        }
        return vet;
    }
}
