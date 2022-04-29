package br.com.bandtec.projetovalidacoes.controle;


import br.com.bandtec.projetovalidacoes.dominio.Estudante;
import br.com.bandtec.projetovalidacoes.repositorio.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/estudantes")
// public class EstudanteResource {
public class EstudanteController {

    @Autowired
    private EstudanteRepository repository;

    @PatchMapping("/foto/{id}")
    public ResponseEntity patchFoto(
       @PathVariable int id,
       @RequestParam MultipartFile foto
    ) throws IOException {
        if (repository.existsById(id)) {
            Estudante estudante =
                    repository.findById(id).get();

            // recuperando o conteúdo do arquivo
            byte[] novaFoto = foto.getBytes();

            // recuperando o TIPO do arquivo
            // ex: text/plain,  image/jpeg, document/msword
            //foto.getContentType();

            // recuperando o nome original do arquivo
            // foto.getOriginalFilename();

            // se fosse necessário tratar o conteúdo como texto
            // String conteudo = new String(foto.getBytes());

            estudante.setFoto(novaFoto);

            repository.save(estudante);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }

    }

    @GetMapping("/foto/{id}")
    public ResponseEntity getFoto(@PathVariable int id){
        if (repository.existsById(id)) {
            Estudante estudante =
                    repository.findById(id).get();

            return ResponseEntity.status(200)
                    .header("content-type","image/jpeg")
                    .body(estudante.getFoto());
        } else {
            return ResponseEntity.status(404).build();
        }
    }

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
