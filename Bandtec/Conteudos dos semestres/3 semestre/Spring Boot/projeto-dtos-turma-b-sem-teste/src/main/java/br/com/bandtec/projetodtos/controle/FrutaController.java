package br.com.bandtec.projetodtos.controle;


import br.com.bandtec.projetodtos.dominio.Fruta;
import br.com.bandtec.projetodtos.repositorio.FrutaRepository;
import br.com.bandtec.projetodtos.requisicao.FrutaNovosUnidadePrecoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frutas")
public class FrutaController {

    @Autowired
    private FrutaRepository repository;

    @GetMapping
    public ResponseEntity get() {
        List<Fruta> frutas = repository.findAll();
        return frutas.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(frutas);
    }

    @GetMapping("/simples")
    public List getSimples() {
        return repository.findAllSimples();
    }

    @GetMapping("/precos")
    public List getPrecos() {
        return repository.findAllPrecos();
    }

    @PatchMapping("/unidade-preco/{id}")
    public void patch(@PathVariable int id,
                      @RequestBody FrutaNovosUnidadePrecoRequest parameter) {
        // não validaremos se o id existe
        repository
            .updatePreco(id, parameter.getNovaUnidade(), parameter.getNovoPreco());
    }

    @GetMapping("/foto/{id}")
    public ResponseEntity getApenasFoto(@PathVariable int id) {
        // não validaremos se o id existe
        byte[] foto = repository.findFotoById(id);
        return ResponseEntity
                .status(200)
                .header("content-type", "image/jpeg")
                .body(foto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity patch(@PathVariable int id,
                                @RequestBody Fruta frutaAtualizada) {
        if (repository.existsById(id)) {
            frutaAtualizada.setId(id);
            repository.save(frutaAtualizada);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    //@GetMapping("/foto/{id}")
    public ResponseEntity getFoto(@PathVariable int id) {
        if (repository.existsById(id)) {
            Fruta fruta = repository.findById(id).get();
            return ResponseEntity
                    .status(200)
                    .header("content-type", "image/jpeg")
                    .body(fruta.getFoto());
        }
        return ResponseEntity.status(404).build();
    }



}
