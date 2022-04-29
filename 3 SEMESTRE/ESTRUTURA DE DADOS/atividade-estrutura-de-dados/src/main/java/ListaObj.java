public class ListaObj<T> {

    private Integer indice;
    private T[] vetor;

    public ListaObj(Integer tamanho) {
        this.indice = 0;
        this.vetor = (T[]) new Object[tamanho];
    }

    public void adiciona(Produto valor) {
        if (vetor.length > indice) {
            System.out.println("\n----------------------\n Adicionando");
            vetor[indice] = (T) valor;
            System.out.println(String.format("\n--------------------- \n valor %s Adicionado no indice", valor));
            indice++;
        } else {
            System.out.println("\n-------------- \n Lista cheia");
        }
    }
    public void exibe() {
        for (int i = 0; i < indice; i++) {
            System.out.println(String.format(" %s no indice %s", vetor[i], i));
        }
    }



}
