package br.com.bandtec.projeto05;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> filmes = new ArrayList<>();

    // EndPoint que traz todos os filmes
    @GetMapping
    public List<Filme> getFilmes() {
        return filmes;
    }

    // EndPoint que traz um filme pelo id
    @GetMapping("/{id}") // GET /filmes/{id}
    public Filme getFilme(@PathVariable int id) {
        return null;
    }

    @DeleteMapping("/{id}") // DELETE /filmes/{id}
    public String deleteFilme(@PathVariable int id) {
        return "";
    }


}
