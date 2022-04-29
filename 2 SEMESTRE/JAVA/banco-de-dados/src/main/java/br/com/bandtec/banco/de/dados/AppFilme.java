
package br.com.bandtec.banco.de.dados;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AppFilme {
    public static void main(String[] args) {
        // Esse é o objeto que possui as configurações com o Banco de dados
        Conexao con = new Conexao();
        
        // Assistente para executar comando no Banco de dados
        
        JdbcTemplate template = new JdbcTemplate(con.getBanco());

        // Insere dados na lista    
//        String criacao = "INSERT INTO filme VALUES (null,?,?,?)";
//        template.update(criacao,"Toy Story", "Animação", 1995);
        
        // buscando dados e colocando em uma lista
        List resultados = template.queryForList("SELECT * FROM filme");
        
        // Exibindo
        System.out.println(resultados);
        
        // Como retornar para uma lista do tipo Filme
        List<Filme> filmes = template.query("SELECT * FROM filme",
                new BeanPropertyRowMapper(Filme.class));
        for (Filme filme : filmes) {
            System.out.println(filme);
        }
     
    }
}
