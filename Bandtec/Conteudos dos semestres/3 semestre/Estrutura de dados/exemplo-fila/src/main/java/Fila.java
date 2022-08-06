public class Fila {
    private int tamanho;
    private String[] fila;

    public Fila(int capacidade){
        fila = new String[capacidade];
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

    public void insert(String info){
        if(isFull()){
            System.out.println("Fila esta cheia!");
        }else{
            fila[tamanho++] = info;
        }
    }

    public String peek(){
        return fila[0];
    }

    public String pool(){
        String filaFirst = fila[0];
        if(isFull()){
            return "Fila esta cheia!";
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
