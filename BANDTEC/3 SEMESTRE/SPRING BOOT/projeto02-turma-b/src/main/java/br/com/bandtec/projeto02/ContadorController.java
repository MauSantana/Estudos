package br.com.bandtec.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
Por padrão, todo Rest Controller é um Singleton
Ou seja, o Spring Boot cria apenas 1 instância
para toda a aplicação
 */
@RestController
public class ContadorController {

    private Integer contador = 0;
    private Integer homens = 0;
    private Integer mulheres = 0;

    @GetMapping("/contagem")
    public String obterContagem() {
        contador++;
        return "Acessos: "+contador;
    }

    @GetMapping("/entrar-homem/{quantidade}")
    public String entrarHomem(
            @PathVariable Integer quantidade) {
        if (homens + mulheres + quantidade > 100) {
            return "Registro não efetuado";
        } else {
            homens += quantidade;
            return quantidade+" homens registrados";
        }
    }

    @GetMapping("/total-pessoas")
    public Integer totalPessoas() {
        return homens + mulheres;
    }

    @GetMapping("/resultado/{nota1}/{nota2}/{nome}")
    public String resultado(@PathVariable Double nota1,
                            @PathVariable Double nota2,
                            @PathVariable String nome) {
        String frase;
        Double media = (nota1+nota2)/2;
        if (media < 6) {
            frase = "Infelizmente, "+nome+", você não passou";
        } else if (media <= 8) {
            frase = "Parabéns, você passou, "+nome;
        } else {
            frase = "Arrasou! "+nome+", você é topper!";
        }
        return frase;
    }

}

