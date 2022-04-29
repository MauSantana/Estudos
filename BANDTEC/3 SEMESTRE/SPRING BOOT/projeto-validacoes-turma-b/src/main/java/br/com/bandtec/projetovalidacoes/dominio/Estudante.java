package br.com.bandtec.projetovalidacoes.dominio;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
}
