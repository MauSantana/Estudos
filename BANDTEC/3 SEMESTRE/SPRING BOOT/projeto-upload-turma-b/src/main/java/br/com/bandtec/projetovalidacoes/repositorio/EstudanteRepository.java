package br.com.bandtec.projetovalidacoes.repositorio;

import br.com.bandtec.projetovalidacoes.dominio.Estudante;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository
 extends JpaRepository<Estudante, Integer> {

}
