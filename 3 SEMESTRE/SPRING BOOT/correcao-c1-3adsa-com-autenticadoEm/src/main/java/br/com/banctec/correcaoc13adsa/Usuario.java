package br.com.banctec.correcaoc13adsa;

import java.time.LocalDateTime;

public class Usuario {

    private String login;
    private String senha;
    private String nome;
    private Boolean autenticado;
    private LocalDateTime autenticadoEm;

    public Usuario(String login, String senha, String nome, Boolean autenticado, LocalDateTime autenticadoEm) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.autenticado = autenticado;
        this.autenticadoEm = autenticadoEm;
    }

    public Boolean autenticar(String login, String senha) {
        boolean entrou = this.login.equals(login) && this.senha.equals(senha);

        if (entrou) {
            this.autenticado = true;
            this.autenticadoEm = LocalDateTime.now();
        }
        return entrou;
    }

    public void logoff() {
        this.autenticado = false;
        this.autenticadoEm = null;
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

    public LocalDateTime getAutenticadoEm() {
        return autenticadoEm;
    }
}
