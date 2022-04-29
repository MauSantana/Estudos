package br.com.bandtec.correcaoc2turmab.repositorio;

import br.com.bandtec.correcaoc2turmab.dominio.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CarroRepository
    extends JpaRepository<Carro, Integer> {

    // exemplos de dynamic finders
    List<Carro> findByModelo(String modelo);

    // exemplo com relacionamento (nome do fabricante)
//    List<Carro> findByFabricanteNome(String nomeFab);

    /* todos os carros com "unidadesVendidas"
       maior que um determinado valor
       E
       nome do fabricante igual a um determinado valor
     */
    /*List<Carro>
    findByUnidadesVendidasGreaterThanAndFabricanteNome(
            Integer unidades, String nomeFab);
*/
    List<Carro> findByDataLancamentoGreaterThan(
            LocalDate data);

    /*
    Crie um endpoint GET /fracassos-venda
    Ele deve trazer todos os carros com menos
    de 10.000 unidades vendidas
     */

    List<Carro> findByUnidadesVendidasLessThan(
            Integer maximo
    );
}
