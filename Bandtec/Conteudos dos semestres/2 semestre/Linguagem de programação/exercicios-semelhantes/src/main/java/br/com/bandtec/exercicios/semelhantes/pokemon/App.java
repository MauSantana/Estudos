package br.com.bandtec.exercicios.semelhantes.pokemon;

public class App {

    public static void main(String[] args) {

        Pokemon p1 = new Pokemon("Pikachu", "eletricidade", 35.6);
        Pokemon p2 = new Pokemon("Charmander", "fogo", 30.0);
        Pokemon p3 = new Pokemon("Squirtle", "aquatico", 31.5);

        System.out.println("EXIBINDO POKEMONS....");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        TreinadorPokemon t1 = new TreinadorPokemon("Ash Ketchum");

        t1.treinarPokemon(p2);
        t1.treinarPokemon(p2);
        t1.treinarPokemon(p2);
        t1.treinarPokemon(p2);
        t1.treinarPokemon(p2);
        
        System.out.println("\nTESTE 1");
        System.out.println("ANTES DA EVOLUÇÃO:");
        System.out.println(p2);

        t1.evoluirPokemon(p2, "Charmeleon");

        System.out.println("APÓS EVOLUÇÃO:");
        System.out.println(p2);

        t1.treinarPokemon(p3);
        t1.treinarPokemon(p3);

        System.out.println("\nTESTE 2");
        System.out.println("ANTES DA EVOLUÇÃO:");
        System.out.println(p3);

        t1.evoluirPokemon(p3, "Wartortle");
    }
}
