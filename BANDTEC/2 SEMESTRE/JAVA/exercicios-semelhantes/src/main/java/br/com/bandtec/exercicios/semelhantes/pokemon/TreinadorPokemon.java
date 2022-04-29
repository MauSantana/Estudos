package br.com.bandtec.exercicios.semelhantes.pokemon;

public class TreinadorPokemon {

    private String nome;
    private Integer nivel;

    public TreinadorPokemon(String nome) {
        this.nome = nome;
        this.nivel = 0;
    }

    public void treinarPokemon(Pokemon pokemon) {

        Double forcaAtual = pokemon.getForca();
        Integer qtdDocesAtual = pokemon.getDoces();

        pokemon.setForca(forcaAtual * 1.1);
        pokemon.setDoces(qtdDocesAtual + 10);

        this.aumentarExperiencia(2);
    }

    public void evoluirPokemon(Pokemon pokemon, String nomeEvolucao) {
        Integer docesAtual = pokemon.getDoces();

        if (docesAtual >= 50) {
            System.out.println(String.format("%s evoluiu para -> %s\n",
                    pokemon.getNome(), nomeEvolucao));

            pokemon.setNome(nomeEvolucao);
            pokemon.setDoces(docesAtual - 50);

            aumentarExperiencia(10);
        } else {
            System.out.println("Voce nao tem a quantia necessária para realizar essa operação.");
        }
    }

    private void aumentarExperiencia(Integer xp) {
        this.nivel += xp;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return String.format("TREINADOR----\n  nome: %s\n  xp: %d\n",
                this.nome, this.nivel);
    }
}
