package br.com.bandtec.projetovalidacoes.controle;


import br.com.bandtec.projetovalidacoes.dominio.Estudante;
import br.com.bandtec.projetovalidacoes.repositorio.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estudantes")
// public class EstudanteResource {
public class EstudanteController {

    @Autowired
    private EstudanteRepository repository;

    @PostMapping
    public ResponseEntity post(
            @RequestBody @Valid Estudante estudante) {
        repository.save(estudante);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public List<Estudante> get() {
        return repository.findAll();
    }
}
