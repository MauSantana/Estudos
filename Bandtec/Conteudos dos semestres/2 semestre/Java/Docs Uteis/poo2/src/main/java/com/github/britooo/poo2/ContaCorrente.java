package com.github.britooo.poo2;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
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
    private Double saldo = 0.0;
    private String situacao = "conta zerada!";

    /* 
        Por padrão os métodos devem ser declarados como públicos e podem ser modificados ao longo do tempo
        de acordo com a necessidade.
    */
    public void depositar50() {
        if ((this.saldo + 50) <= 200) {
            this.saldo += 50;
            this.verificaSituacaoFinanceira();
            System.out.println("Depósito efetuado com sucesso!");
        } else {
            System.out.println(String.format("Conta já atingiu o limite: R$%.2f", saldo));
        }
    }

    public void sacar50() {
        if ((this.saldo - 50) >= 0) {
            this.saldo -= 50;
            this.verificaSituacaoFinanceira();
            System.out.println("Saque efetuado com sucesso!");
        } else {
            System.out.println(String.format("Saldo insuficiente: R$%.2f", saldo));
        }
    }

    private void verificaSituacaoFinanceira() {
        if (this.saldo > 100) {
            this.situacao = "Razoavel";
        } else {
            this.situacao = "Ta gastando muito";
        }
    }

    /*
        Para recuperar informações(atributos de uma classse ou até uma informação
        representada por um conjunto de atributos) privadas utilizamos o padrão "get..."
    
        O desenvoldedor(a) deve entender a necessidade e somente expor os dados
        triviais para uso da classe ou seja, você deve decidir o que quer expor
        logo o uso de getter é opcional.
    */ 
    public Double getSaldo() {
        return this.saldo;
    }

    public String getSituacao() {
        return this.situacao;
    }

    /*
        Quando queremos fornecer a opossibilidade de alterar um atributo
        utilizamos o padrão "set..."
    
        O desenvoldedor(a) deve entender a necessidade e somente expor os dados
        triviais para uso da classe ou seja, você deve decidir o que quer expor
        logo o uso de setter é opcional.
    */ 
    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = "Sr(a) " + cliente;
    }

}
