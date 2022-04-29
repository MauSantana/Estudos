package com.example.backend.controle;


import com.example.backend.dominio.Vitima;
import com.example.backend.repository.ContatosEmergenciaisRepository;
import com.example.backend.repository.EnderecoRepository;
import com.example.backend.repository.VitimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/vitimas")
public class VitimaController {

    @Autowired
    private VitimaRepository repositoryVitima;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ContatosEmergenciaisRepository contatosEmergenciaisRepository;

    //    CADASTRO DA VITIMA
    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody Vitima vitima) {

        enderecoRepository.save(vitima.getEndereco());

        vitima.getContatosEmergenciais()
                .forEach(contatosEmergenciaisRepository::save);

        repositoryVitima.save(vitima);

        return ResponseEntity.status(201).body(vitima);
    }

    //    PUXANDO TODOS
    @GetMapping
    public ResponseEntity exibirVitimas() {

        List<Vitima> vitimas = repositoryVitima.findAll();

        if (vitimas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(vitimas);
    }

    //    ALTERANDO UM ATRIBUTO DA VITIMA
    @PutMapping("/{id}")
    public ResponseEntity putVitima(@PathVariable int id,
                                    @RequestBody Vitima vitimaAltarada) {
        if (repositoryVitima.existsById(id)) {
            vitimaAltarada.setNumeroDoCadastro(id);
            repositoryVitima.save(vitimaAltarada);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

    //    PUXANDO APENAS UMA VITIMA
    @GetMapping("/{id}")
    public ResponseEntity getVitima(@PathVariable int id) {

        return ResponseEntity.of(repositoryVitima.findById(id));
    }


    @GetMapping("/EstadoCivil/{moraComParceiro}")
    public ResponseEntity estadoCivil(Boolean moraComParceiro){
        if (repositoryVitima.findByEstadoCivil(moraComParceiro)== null){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(repositoryVitima.findByEstadoCivil(moraComParceiro));
    }

    // LOGIN DA VITIMA
    @GetMapping("/login/{userName}/{senha}")
    public ResponseEntity login(@PathVariable String userName, @PathVariable String senha) {

        List<Vitima> vitimas = repositoryVitima.findByUsernameAndSenha(userName, senha);

        if (vitimas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(repositoryVitima.findByUsernameAndSenha(userName, senha));
    }


}
