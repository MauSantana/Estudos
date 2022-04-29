package br.com.bandtec.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
A anotação @RestController indica que a classe
será uma controladora Rest
Ou seja, podem haver 1 ou mais EndPoints configurados nela
 */
@RestController
public class AprendizadoController {

    /*
A anotação @GetMapping é uma forma de transformar um método
em um EndPoint
O termo dentro dela é a URI
     */
    @GetMapping("/frase") // a URI é /frase
    public String frase() {
        return "É nóis no Spring Boot";
    }

    @GetMapping("/cumprimento") // a URI é /cumprimento
    public String cumprimento() {
        return "Boa noite, galera!";
    }

    /*
Aqui a URI possui um PATH PARAM.
O PATH PARAM é "numero"
@PathVariable faz a "ligação" entre o PATH PARAM da URI
              e um dos parâmetros do método
     */
    @GetMapping("/dobro/{numero}") // 8080:dobro/20
    public String calcularDobro(@PathVariable Integer numero) {
        return "O numero de "+numero+" é "+(numero*2);
    }

/*
É possível ter quantos PATH PARAMS você quiser.
Só que cada parâmetro deve estar anotado com @PathVariable
 */
    @GetMapping("/somar/{n1}/{n2}")
    public String calcularSoma(
            @PathVariable Double n1, @PathVariable Double n2) {
       return n1 + " + " + n2 + " = " + (n1+n2);
    }
}
