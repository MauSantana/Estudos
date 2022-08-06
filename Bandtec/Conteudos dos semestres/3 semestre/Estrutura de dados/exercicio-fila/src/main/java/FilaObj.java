public class FilaObj <F>{
    private int tamanho;
    private F[] fila;

    public FilaObj(int capacidade){
        fila = (F[]) new Object[capacidade];
        tamanho = 0;
    }

    public boolean isEmpty(){
        if (tamanho == 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull(){
        return tamanho == fila.length;
    }

    public void insert(F info){
        if(isFull()){
            System.out.println("Fila esta cheia!");
        }else{
            fila[tamanho++] = info;
        }
    }

    public F peek(){
        return fila[0];
    }

    public F pool(){
        F filaFirst = fila[0];
        if(isFull()){
            return (F)"fila cheia";
        }else{
            for(int i = 0; i < tamanho - 1;i++){
                fila[i] = fila[i+1];
            }
            fila[tamanho - 1] = null;
            tamanho--;
            return filaFirst;
        }
    }

    public void exibe(){
        if(isEmpty()){
            System.out.println("Fila vazia!");
        }else{
            for(int i = 0; i < tamanho; i++){
                System.out.println(fila[i]);
            }
        }
    }
}
