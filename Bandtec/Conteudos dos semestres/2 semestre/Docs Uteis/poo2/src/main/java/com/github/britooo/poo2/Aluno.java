
package com.github.britooo.poo2;

import java.util.concurrent.ThreadLocalRandom;
import javax.print.attribute.standard.Media;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 */
public class Aluno {
    
    /*
        Lembrando nossa regra de ouro:
            - Atributos "nascem" privados e podem ser alterados de acordo com o contexto.
    */
    private Integer ra;
    private String nome;
    private String curso;
    private Double notaFinal;
    
    /*
        O construtor é um trecho de código que é invocado no ato de instância de um objeto.
        O objetivo dele é auxiliar na construção do objeto, inicializando e/ou
        realizando operações triviais para utilização do objeto.
    
        Os argumentos são opcionais e ficam a critério do desenvolvedor(a)
        decidir o que o usuário(outro programador(a)) deve informa no ato da 
        inicialização de um objeto( new MeuObjeto(....)).
    
        Você pode ter mais de um construtor em uma classe, ou seja,
        você pode sobrecarregar o construtor mudando os argumentos exigidos e quem
        utilizar decidide qual vai ser mais apropriado para o contexto de utilização.
    
        Os contrutores carregam o nome da classe.
    
        Caso você não declare um construtor em sua classe, o próprio Java fará isso por você,
        invocado um construtor que chamamos de "construtor default ou padrão"
        Exemplo:
        
            public Aluno() {

            }
        
        Isso mesmo, ele cria um construtor vazio para tornar possível a criação dos objetos
        oriundos de sua classe.
    
        Você pode fazer todo tipo de validação e invocar métodos dentro dele,
        como se fosse uma espécie de "método" embora não seja um.
    
        Abaixo um exemplo de uso dos contrutores, onde na aula decidimos somente exigir
        nome e curso, mas observe, inicializamos outros atributos por mais que eles
        não estejam sendo exigidos.
    */
    public Aluno(String nome, String curso) {
        this.ra = ThreadLocalRandom.current().nextInt(0, 5001);
        this.nome = nome;
        this.curso = curso;
        this.notaFinal = 0.0;
    }
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getRa() {
        return ra;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }
    
    /*
        Para evitar a impressão no console de um "hashcode" estranho,
        sobreescrevemos um método, no caso o método "toString()".
    
        Basta retorna uma string com os valores que deseja exibir, e quando
        alguem tentar imprimir seu objeto no console ele será acionado, fornecendo
        ingormações mais relevantes ao desenvolvedor(a).
    
        Explicaremos com mais calma isso nas próximas aulas.
    */
    @Override
    public String toString() {
        return String.format("Nome: %s , RA: %d", this.nome, this.ra);
    }

    
    
}
