package br.com.bandtec.projetodtos.repositorio;

import br.com.bandtec.projetodtos.dominio.Fruta;
import br.com.bandtec.projetodtos.resposta.FrutaPrecoResponse;
import br.com.bandtec.projetodtos.resposta.FrutaSimplesResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FrutaRepository extends JpaRepository<Fruta, Integer> {

    /*
    Esta anotação é usada para consultas com JPQL.
    Nesta abordagem o select só usará os campos na instrução
    neste caso, o 'id' e o 'nome'
     */
    @Query("select new br.com.bandtec.projetodtos.resposta.FrutaSimplesResponse(f.id, f.nome) from Fruta f")
    List<FrutaSimplesResponse> findAllSimples();

    /*
    Neste exemplo, FrutaSimplesResponse precisa de um construtor
    que recebe uma Fruta
    Porém, nesta abordagem, o select busca TODOS os campos
     */
    @Query("select f from Fruta f")
    List<FrutaSimplesResponse> findAllSimples2();


    @Query("select new br.com.bandtec.projetodtos.resposta.FrutaPrecoResponse(f.id, f.nome, f.quantidadeEstoque, f.precoUnitario) from Fruta f")
    List<FrutaPrecoResponse> findAllPrecos();


    /*
    @Modifying e @Transactional são OBRIGATÓRIAS caso usemos instruções
    que alteram dados na @Query
     */
    @Modifying
    @Transactional // do pacote org.springframework....
    @Query("update Fruta f set f.unidade = ?2, f.precoUnitario = ?3 where f.id = ?1")
    void updatePreco(Integer id, String novaUnidade, Double novoPreco);

    // é possível retorna apenas um campo se for o caso
    // então, o retorno do método é o tipo do campo
    @Query("select f.foto from Fruta f where f.id = ?1")
    byte[] findFotoById(Integer id);

}
