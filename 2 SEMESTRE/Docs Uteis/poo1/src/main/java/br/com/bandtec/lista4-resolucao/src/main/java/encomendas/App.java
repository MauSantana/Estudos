
package encomendas;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class App {
    
    public static void main(String[] args) {
        
        Encomenda encomenda1 = new Encomenda();
        
        encomenda1.altura = 10.0;
        encomenda1.largura = 10.0;
        encomenda1.enderecoDestinatario = "Rua Javao da massa,\nnº 352, SP";
        encomenda1.enderecoRemetente = "Rua Haddock Lobo, \nnº 595, SP";
        encomenda1.distancia = 40.0;
        encomenda1.valorEncomenda = 10.0;
        
        encomenda1.emitirEtiqueta();
    }
}
