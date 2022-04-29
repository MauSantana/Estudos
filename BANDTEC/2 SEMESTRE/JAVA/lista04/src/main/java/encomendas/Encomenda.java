
package encomendas;


public class Encomenda {
    Double altura;
    Double largura;
    String enderecoRemetente;
    String enderecoDestinatario;
    Double distancia;
    Double valorEncomenda;
    Double valorFrete;
    
    void calcularFrete(){
        if ((altura >0 && altura <=6) && (largura >0 && largura <=6)) {
             valorEncomenda = valorEncomenda * 1.01;
        }else if((altura >=7 && altura <=15) && (largura >=16 && largura <=50)) {
             valorEncomenda = valorEncomenda * 1.03;
        }else if (altura >=16 && largura >=51) {
             valorEncomenda = valorEncomenda * 1.05;
    }else {
            System.out.println("valor inválido");
        }
        
}
    void calculoFreteDistancia() {
        if (distancia <= 50) {
            valorFrete +=3;
        }else if(distancia >=51 && distancia <=200) {
            valorFrete +=5;
        }else {
             valorFrete +=7;
        }
    }
    void emitirEtiqueta(){
        Double valorTotal = valorEncomenda + valorFrete;
        System.out.println(String.format("***** Etiqueta para envio *****\nEndereço do remetente: %s \nEndereço do destinatário %s\n"
                + "Altura da encomenda: %.1f cm\n"
                + "Largura da Encomenda: %.1f cm\n"
                + "------------------------------\n"
                + "Valor da Encomenda: R$%.2f \n"
                + "Valor do Frete: R$%.2f \n"
                + "------------------------------\n"
                + "Valor Total: R$%.2f \n", enderecoRemetente, enderecoDestinatario,
        altura, largura, valorEncomenda, valorFrete, valorTotal));
    }
}
