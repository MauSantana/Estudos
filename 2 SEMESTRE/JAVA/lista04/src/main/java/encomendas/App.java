
package encomendas;

public class App {
    public static void main(String[] args) {
        
        Encomenda encomenda1 = new Encomenda();
        
        encomenda1.enderecoRemetente = "Albertina de Medeiros ,1344";
        encomenda1.enderecoDestinatario = "Baixada ,1555";
        encomenda1.altura = 13.0;
        encomenda1.largura = 25.0;
        encomenda1.valorEncomenda = 150.0;
        encomenda1.valorFrete = 0.0;
        encomenda1.distancia = 40.0;
        
        encomenda1.calcularFrete();
        encomenda1.calculoFreteDistancia();
        encomenda1.emitirEtiqueta();
        
    }
}
