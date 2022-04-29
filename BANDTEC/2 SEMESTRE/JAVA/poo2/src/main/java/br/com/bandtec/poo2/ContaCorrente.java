
package br.com.bandtec.poo2;


public class ContaCorrente {
    /*
        Podemos utilizar os seguintes modificadores de acesso no Java:
        private
        public
        protected
        default(padrão, sem declarações explicítas no atributo ou método)
     
        Por padrão os atributos devem ser declarados como privados e podem ser modificados ao longo do tempo
        de acordo com a necessidade.
    */ 
    private String cliente;
    private Double saldo;
    private String situacao = "conta zerada";
    /* 
        Por padrão os métodos devem ser declarados como públicos e podem ser modificados ao longo do tempo
        de acordo com a necessidade.
    */
    public void depositar50(){
        if ((saldo + 50) <= 200) {
        saldo += 50;
            System.out.println("Deposito efetuado");
        }else {
            System.out.println(String.format("Limite atingido: %.2f", saldo));
    }
        }
    
    public void sacar50(){
        if ((saldo - 50) >= 0) {
        saldo -= 50;
        verificaSituacaoFinanceira ();
        System.out.println(String.format("Saldo: %.2f", saldo));
    }else {
            System.out.println(String.format("Saldo insuficiente: %.2f", saldo));
        }
    }
    
    private void verificaSituacaoFinanceira () {
        if (saldo> 100) {
            situacao = "razoavel";
        }else {
            situacao = "gastando muito";
            
        }
    }
//    Double recuperarSaldo(){
//        return saldo;
//    }
  
    /*
    
        Para recuperar informações(atributos de uma classse ou até uma informação
        representada por um conjunto de atributos) privadas utilizamos o padrão "get..."
    
        O desenvoldedor(a) deve entender a necessidade e somente expor os dados
        triviais para uso da classe ou seja, você deve decidir o que quer expor
        logo o uso de getter é opcional.
    */ 

    public Double getSaldo() {
        return saldo;
    }

    public String getSituacao() {
        return situacao;
    }
     /*
        Quando queremos fornecer a opossibilidade de alterar um atributo
        utilizamos o padrão "set..."
    
        O desenvoldedor(a) deve entender a necessidade e somente expor os dados
        triviais para uso da classe ou seja, você deve decidir o que quer expor
        logo o uso de setter é opcional.
    */ 

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    //
    
    
        
 }
