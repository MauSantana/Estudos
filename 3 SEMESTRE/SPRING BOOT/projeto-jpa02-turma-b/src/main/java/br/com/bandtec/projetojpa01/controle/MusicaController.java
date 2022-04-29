package br.com.bandtec.projetojpa01.controle;

import br.com.bandtec.projetojpa01.dominio.Musica;
import br.com.bandtec.projetojpa01.repositorio.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaRepository repository;

    @GetMapping
    public ResponseEntity getMusicas() {
        List<Musica> musicas = repository.findAll();

        if (musicas.isEmpty()) {
            /*
            Resposta com status 204
            E corpo vazio - build()
             */
            return ResponseEntity.status(204).build();
        }

        /*
            Resposta com status 200
            No corpo será usado o conteúdo da lista "musicas"
         */
        return ResponseEntity.status(200).body(musicas);
    }

    @PostMapping
    public ResponseEntity postMusica(@RequestBody Musica novaMusica) {
        repository.save(novaMusica);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getMusica(@PathVariable int id) {
        /*
ResponseEntity.of() -> pode retornar 2 coisas:
SE o objeto tiver valor: status 200 e o valor no corpo
SE o objeto NÃO tiver valor: status 404 e sem corpo

OBS: esse método só funciona para Optional
     que é o caso do método findById()
         */
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMusica(@PathVariable int id) {
        // existsById() verifica a existência daquela PK
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity putMusica(@PathVariable int id,
                            @RequestBody Musica musicaAlterada) {
        if (repository.existsById(id)) {
            musicaAlterada.setId(id);
            repository.save(musicaAlterada);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

    @GetMapping("/letra/{id}")
    public ResponseEntity getLetra(@PathVariable int id) {
        if (repository.existsById(id)) {
            Musica musica = repository.findById(id).get();

            // aqui estamos retornando um cabeçalho de resposta
            // chamado "content-type", que indica o tipo de conteúdo
            // que será entregue no corpo da resposta
            return ResponseEntity
                    .status(200)
                    .header("content-type", "application/pdf")
                    .body(musica.getLetra());
        }
        return ResponseEntity.status(404).build();
    }


}
