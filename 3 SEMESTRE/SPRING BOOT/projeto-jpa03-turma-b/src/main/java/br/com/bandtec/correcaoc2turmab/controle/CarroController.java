package br.com.bandtec.correcaoc2turmab.controle;

import br.com.bandtec.correcaoc2turmab.dominio.Carro;
import br.com.bandtec.correcaoc2turmab.repositorio.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroRepository repository;

    @PostMapping
    public ResponseEntity postCarro(
            @RequestBody Carro carro) {
        repository.save(carro);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getCarro(
            @PathVariable int id) {
        return
        ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarro(
            @PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return
            ResponseEntity.status(200).build();
        } else {
            return
            ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity getCarros() {
        List<Carro> carros = repository.findAll();

        if (carros.isEmpty()) {
            return
            ResponseEntity.status(204).build();
        } else {
            return
            ResponseEntity.status(200).body(carros);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putCarro(
            @PathVariable int id,
            @RequestBody Carro carro) {
        if (repository.existsById(id)) {
            carro.setId(id);
            repository.save(carro);
            return ResponseEntity.status(200).build();
        } else {
            return
            ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/contagem")
    public ResponseEntity contagem() {
        return ResponseEntity.status(200)
                .body(repository.count());
    }

    @GetMapping("/contagem-b")
    public long contagemB() {
        return repository.count();
    }


    @GetMapping("/relatorio")
    public ResponseEntity relatorio() {

        String conteudo = String.format(
                "Relatório de Carros\n Carros cadastrados: %s\n",
                repository.count()
        );
        for (Carro carro : repository.findAll()) {
            conteudo += String.format(
                    "\nCarro %d: %s - %d unidades vendidas"
                    , carro.getId(), carro.getModelo(), carro.getUnidadesVendidas()
            );
        }

        return ResponseEntity
                .status(200)
                .header("content-type", "text/plain")
                .body(conteudo);
    }

    @GetMapping("/por-modelo/{modelo}")
    public List<Carro> getCarrosPorModelo(
            @PathVariable String modelo
    ) {
        return repository.findByModelo(modelo);
    }

    @GetMapping("/semi-novos")
    public List<Carro> getSemiNovos() {
        LocalDate trezeAnos =
                LocalDate.now().plusYears(-13);

        return repository.
        findByDataLancamentoGreaterThan(trezeAnos);
    }

    @GetMapping("/fracassos-venda")
    public List<Carro> getFracassos() {
        return repository.
        findByUnidadesVendidasLessThan(10_000);
    }

}
