package br.com.bandtec.banco.de.dados;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexao {

    private BasicDataSource banco;

    public Conexao() {
        this.banco = new BasicDataSource();
        banco.setDriverClassName("org.h2.Driver");
        banco.setUrl("jdbc:h2:file:./meu_banco");
        banco.setUsername("sa");
        banco.setPassword("");

    }

    public BasicDataSource getBanco() {
        return banco;
    }
       

}
