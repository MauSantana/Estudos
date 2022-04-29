
package br.com.bandtec.exemplo.agrecacao;

public class Contato {
    
    private String nome;
    private String telefone;
    private Boolean bloqueado;
    
    public void bloquear(){
        this.bloqueado = true;
    }
    
    public void desbloquear(){
        this.bloqueado = false;

    }

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.bloqueado = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean isBloqueado() {
        return bloqueado;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s/nTelefone: %s/nBloqueado %s",
                this.nome,
                this.telefone,
        (bloqueado ? "Está bloqueado" : "Está bloqueado"));
    }

    
    
}
