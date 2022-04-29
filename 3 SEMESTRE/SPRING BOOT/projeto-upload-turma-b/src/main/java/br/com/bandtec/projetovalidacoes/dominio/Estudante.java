package br.com.bandtec.projetovalidacoes.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore // será ignorado no JSON
    @Column(length = 20_000_000) // 20MB
    private byte[] foto;

    @NotNull // é do javax.validation.constraints...
    @NotBlank // faz o "trim" e depois valida
    @Size(min = 5, max = 50)
    private String nome;

    @CPF
    private String cpf;

    @Email  // é do javax.validation.constraints...
    private String email;

    @Min(0)
    private Integer filhos;

    @Past
    // @PastOrPresent
    private LocalDate nascimento;

	// expressão regular (regex)
    @Pattern(regexp = "\\d{5}(-\\d{3})?",
                message = "Digite um CEP válido")
    private String cep;


    // criar os getters e setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFilhos() {
        return filhos;
    }

    public void setFilhos(Integer filhos) {
        this.filhos = filhos;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
