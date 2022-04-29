public class Teste {

    public static void separaPositivoNegativoEmOrdem(Integer[] v) {
        FilaObj<Integer> filaPositivo = new FilaObj<>(v.length);
        FilaObj<Integer> filaNegativo = new FilaObj<>(v.length);

        for (int i = 0; i < v.length; i++) {
            if (v[i] >= 0) {
                filaPositivo.insert(v[i]);
            }
            else{
                filaNegativo.insert(v[i]);
            }
        }

        while (!filaPositivo.isEmpty()) {
            System.out.print(filaPositivo.poll() + "\t");
        }

        while (!filaNegativo.isEmpty()) {
            System.out.print(filaNegativo.poll() + "\t");
        }

        System.out.println();

    }



    public static void separaPositivoNegativoOrdemDiferente(Integer[] v) {
        FilaObj<Integer> filaPositivo = new FilaObj<>(v.length);
        PilhaObj<Integer> pilhaNegativo = new PilhaObj<>(v.length);

        for (int i = 0; i < v.length; i++) {
            if (v[i] >= 0) {
                filaPositivo.insert(v[i]);
            }
            else{
                pilhaNegativo.push(v[i]);
            }
        }

        while (!filaPositivo.isEmpty()) {
            System.out.print(filaPositivo.poll() + "\t");
        }

        while (!pilhaNegativo.isEmpty()) {
            System.out.print(pilhaNegativo.pop() + "\t");
        }

        System.out.println();

    }







    public static void main(String[] args) {
        Integer[] vetor = {2, 7, -3, -50, 45, -4, 30, -21, 38};

        separaPositivoNegativoEmOrdem(vetor);

        separaPositivoNegativoOrdemDiferente(vetor);
    }
}
