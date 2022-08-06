package br.com.banctec.correcaoc13adsa;

public class Usuario {

    private String login;
    private String senha;
    private String nome;
    private Boolean autenticado;

    public Usuario(String login, String senha, String nome, Boolean autenticado) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.autenticado = autenticado;
    }

    public Boolean autenticar(String login, String senha) {
        boolean entrou = this.login.equals(login) && this.senha.equals(senha);
        this.autenticado = entrou;
        return entrou;
    }

    public void logoff() {
        this.autenticado = false;
    }

    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

}
