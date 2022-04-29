public class ListaObj<T> {

    private Integer indice;
    private T[] vetor;

    public ListaObj(Integer tamanho) {
        this.indice = 0;
        this.vetor = (T[]) new Object[tamanho];
    }

    public void adicionar(Aluno valor) {
        if (vetor.length > indice) {
            System.out.println("\n---------------------------------- \n Adicionando.........");
            vetor[indice] = (T) valor;
            System.out.println(String.format("\n---------------------------------- \n valor %s Adicionado no indice", valor));
            indice++;
        } else {
            System.out.println("\n---------------------------------- \n Lista cheia........");
        }
    }

    public void exibe() {
        System.out.println("\n----------------------------------\n exibindo..... ");
        for (int i = 0; i < indice; i++) {
            System.out.println(String.format("\nElemento %s no indice %s", vetor[i], i));
        }
    }

    public Integer procurar(Integer numero) {

        System.out.println("\n----------------------------------\n procurando..... ");
        for (int i = 0; i < indice; i++) {
            if (numero.equals(vetor[i])) {
                System.out.println("Encontrado no indice "+ vetor[i]);
                return i;
            }
        }

        System.out.println("não encontrado -1");
        return -1;
    }


    public void limpar() {
        indice = 0;
        System.out.println("\nLimpada com sucesso"+ vetor[indice] );
    }

}