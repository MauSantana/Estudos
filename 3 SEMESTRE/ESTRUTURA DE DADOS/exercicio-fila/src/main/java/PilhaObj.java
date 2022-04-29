public class PilhaObj <P>{

    // Atributos
    private P[] pilha;
    private int topo;

    // Construtor
    public PilhaObj(int capacidade) {
        pilha = (P[]) new Object[capacidade];
        topo = -1;
    }

    // Métodos

    public Boolean isEmpty() {
        return topo == -1;

// A instrução acima equivale a esse bloco de instruções
//        if (topo == -1) {
//            return true;
//        }
//        else {
//            return false;
//        }
    }

    public Boolean isFull() {
        return topo == pilha.length-1;
    }

    public void push(P info) {
        if (isFull()) {
            System.out.println("Pilha cheia!");
        }
        else {
//            topo++;
//            pilha[topo] = info;
            // as 2 instruções acima equivalem a esta abaixo:
            pilha[++topo] = info;
        }
    }

    public P pop() {
        if (isEmpty()) {
            return null;
        }
//        int retorno = pilha[topo];
//        topo--;
//        return retorno;

        return pilha[topo--];
    }

    public P peek() {
        if (isEmpty()) {
            return null;
        }
        return pilha[topo];
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        }
        else {
            for (int i = topo; i >= 0; i--) {
                System.out.println(pilha[i]);
            }
        }
    }

    public boolean ehPalindromo(Integer vetor[]){
        PilhaObj<Integer> pilha = new PilhaObj(vetor.length);


        for(int i = 0; i < vetor.length; i++){
            pilha.push(vetor[i]);
        }

        for(int i = 0; i < vetor.length; i++) {
            if (vetor[i] != pilha.pop()){
                return false;
            }
        }
        return true;
    }

    public Boolean ehPalindromoFrase(char vetor[]){
        int j = (vetor.length-1);
        for(int i = 0; i < j; i++) {
            if (vetor[i] != vetor[j]){
                return false;
            }else {
                j = j - 1;
            }
        }
        return true;

    }

    public void converteBinario(Integer num){
        PilhaObj pilhaObj = new PilhaObj((int) (Math.log(num) / Math.log(2) + 1));
        int numOriginal = num;
        while (num != 0){
            pilhaObj.push(num % 2);
            num /= 2;
        }

        System.out.print(numOriginal + "    em binario é: ");
        while (!pilhaObj.isEmpty()){
            System.out.print(pilhaObj.pop());
        }

        System.out.println();
    }
}
