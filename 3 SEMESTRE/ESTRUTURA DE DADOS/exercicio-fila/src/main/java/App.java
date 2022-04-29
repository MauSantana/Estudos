public class App {
    public static void main(String[] args) {
        int vetor[] = {1, 3, 4, 10, -2, -4, -3};
        int vetorD[] = {2, 7, -3, -50, 45, -4, 30, -21, 38};
        //separaPositivoNegativoEmOrdem(vetor);
        separaPositivoNegativoOrdemDiferente(vetorD);
    }
    public static void separaPositivoNegativoEmOrdem(int v[]){
        FilaObj<Integer> filaPositivo = new FilaObj(v.length);
        FilaObj<Integer> filaNegativo = new FilaObj(v.length);
        for (int i = 0; i < v.length;i++){
            if(v[i] < 0){
                filaNegativo.insert(v[i]);
            }else{
                filaPositivo.insert(v[i]);
            }
        }
        while(!filaPositivo.isEmpty()) {
            System.out.print(filaPositivo.pool()+ "\t");
        }
        while(!filaNegativo.isEmpty()){
            System.out.print(filaNegativo.pool()+ "\t");
        }
    }

    public static void separaPositivoNegativoOrdemDiferente(int v[]){
            FilaObj<Integer> fila = new FilaObj(v.length);
            PilhaObj<Integer> pilha = new PilhaObj(v.length);

            for(int i = 0; i < v.length; i++){
                if(v[i] < 0){
                    pilha.push(v[i]);
                }else{
                    fila.insert(v[i]);
                }
            }

            while(!fila.isEmpty()){
                System.out.print(fila.pool()+ "\t");
            }
            
            while(!pilha.isEmpty()){
                System.out.print(pilha.pop()+ "\t");
            }


    }
}




