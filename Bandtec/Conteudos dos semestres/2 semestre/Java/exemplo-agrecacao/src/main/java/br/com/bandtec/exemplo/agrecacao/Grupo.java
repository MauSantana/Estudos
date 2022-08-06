
package br.com.bandtec.exemplo.agrecacao;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nome;
    private List<Contato> contatos;

    public Grupo(String nome) {
        this.nome = nome;
        this.contatos = new ArrayList();
    }
    
    public void adiciona(Contato contato){
        contatos.add(contato);
    }
    
    public void remove(Contato contato){
        contatos.remove(contato);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    @Override
    public String toString() {
        return "Grupo{" + "nome=" + nome + ", contatos=" + contatos + '}';
    }

    
    
}
