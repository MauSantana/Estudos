package br.com.bandtec.projetojpa01.repositorio;

import br.com.bandtec.projetojpa01.dominio.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Interface com os métodos de acesso a banco para a entidade Musica

<Musica, Integer>
 Musica -> Tipo da Entidade
 Integer -> Tipo da PK da Entidade (note que é o tipo do atributo anotado com @Id em Musica)
 */
public interface MusicaRepository extends JpaRepository<Musica, Integer> {

}
