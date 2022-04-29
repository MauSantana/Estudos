/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.ac3.so;

import com.github.britooo.looca.api.core.Looca;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Mauri
 */
public class App {
    public static void main(String[] args) throws UnknownHostException {
        Conexao con = new Conexao();
        ConexaoMySql con2 = new ConexaoMySql();
        
        JdbcTemplate config = new JdbcTemplate(con.getDatasource());
        JdbcTemplate config2 = new JdbcTemplate(con2.getDatasource());
//        JdbcTemplate config2 = new JdbcTemplate(con2.getDatasource());

        Recurso recurso = new Recurso();

        // Parametros para o primeiro insert
   
        String momento =  recurso.getMomento();
        Double consumoRam = recurso.getConsumoRam();
        Double consumoCpu = recurso.getConsumoCPU();
        Double consumoDisco = recurso.getConsumoDisco();
       
      
        // Texto padrão para insert
        String insertStatement = "INSERT INTO Recurso (fkEquipamento, consumoRam, consumoCpu, consumoDisco, momento) VALUES (?, ?, ?, ?, ?)";
        
        // Utilizamos o comando "update" para inserir e/ou atualizar registros.
        // Podemos utilizar variavéis como o exemplo abaixo:
                //ALTERE A FK DE ACORDO COM SEU EQUIPAMENTO
        config.update(insertStatement, 4, consumoRam, consumoCpu, consumoDisco, momento);
        config2.update(insertStatement, 4, consumoRam, consumoCpu, consumoDisco, momento);
//        config2.update(insertStatement, 5, consumoRam, consumoCpu, consumoDisco, momento);              

        // Para buscar informações devemos utilizar o comando queryForList ou query,
        // exemplo de uso do queryForList:
        List recursoSimpleUse = config.queryForList("SELECT * FROM Recurso");        


        // Exibindo o resultado
        System.out.println("Dados inseridos!");

    }
}
