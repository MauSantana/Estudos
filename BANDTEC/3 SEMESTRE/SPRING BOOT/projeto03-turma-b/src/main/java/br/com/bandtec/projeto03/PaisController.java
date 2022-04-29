package br.com.bandtec.projeto03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PaisController {

    private List<Pais> paises = new ArrayList<>();

    @GetMapping("/campeao")
    public Pais getCampeao() {
        Pais campeao = new Pais("EUA", 30, 20, 10);
        return campeao;
    }

    @GetMapping("/top3")
    public List<Pais> getTop3() {
        List<Pais> top3 = List.of(
          new Pais("EUA", 30, 20, 10),
          new Pais("China", 25, 15, 5),
          new Pais("Japão", 10, 5, 3)
        );
        return top3;
    }

    @GetMapping("/todos")
    public List<Pais> getPaises() {
        return paises;
    }

    @GetMapping("/cadastrar/{nome}/{ouros}/{pratas}/{bronzes}")
    public String cadastrar(@PathVariable String nome,
                            @PathVariable Integer ouros,
                            @PathVariable Integer pratas,
                            @PathVariable Integer bronzes
                            ) {
        Pais novo = new Pais(nome, ouros, pratas, bronzes);
        paises.add(novo);
        return "Cadastrado com sucesso";
    }

/*
EndPoint /recuperar/{indice}
Ele retorna 1 país conforme o "indice".
Ex: /recuperar/0 -> traz o JSON do primeiro país cadastrado
Ex: /recuperar/3 -> traz o JSON do 4º país cadastrado
OBS: Não precisa tratar erro pro caso do "indice" ser inválido
 */

    @GetMapping("/recuperar/{indice}")
    public Pais recuperar(@PathVariable Integer indice) {
        return paises.get(indice);
    }
}
