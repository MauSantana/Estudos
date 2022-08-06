
package br.com.bandtec.teste.listas;

import java.util.ArrayList;
import java.util.List;


public class App2 {
    public static void main(String[] args) {
        
        List<String> bandas = new  ArrayList<>();
        
        bandas.add("PP da VS");
        bandas.add("Hariel");
        bandas.add("Salvador da Rima");
        bandas.add("MC Kevin");
        
//        for (int i = 0; i < bandas.size(); i++) {
//            System.out.println("Banda: " + bandas.get(i));
//        }
//        System.out.println("\nFiltrando Bandas");
//        for (int i = 0; i < bandas.size(); i++) {
//            String bandaDaVez = bandas.get(i);
//            if (bandaDaVez.equals("Hariel")) {
//                System.out.println(bandaDaVez);
//            }
//        }
//        System.out.println("\nFiltrando Bandas: Letra S");
//        for (int i = 0; i < bandas.size(); i++) {
//            String bandaDaVez = bandas.get(i);
//            if (bandaDaVez.contains("S")) {
//                System.out.println(bandaDaVez);
//            }
//        }
        
//        bandas.remove("PP da VS");
//        
//        System.out.println(bandas);
        
//        System.out.println("\nDeletando Banda");
//        for (int i = 0; i < bandas.size(); i++) {
//            String bandaDaVez = bandas.get(i);
//            if (bandaDaVez.contains("PP da VS")) {
//                bandas.remove(i);
//            }
//        }
//        
//        System.out.println(bandas);  
        
//        for (String banda : bandas) {
//            System.out.println(banda);
//        }
//        List<Integer> numerosInteiros = new ArrayList<>();
//        
//        numerosInteiros.add(10);
//        numerosInteiros.add(20);
//        numerosInteiros.add(30);
//        
//        System.out.println("");
//        
//        for(Integer numero : numerosInteiros){
//            System.out.println(numero);
//        }

        List<Aluno> alunos = new ArrayList<>();
        
        Aluno a1 = new Aluno(1, "Mauricio");
        Aluno a2 = new Aluno(2, "Diguinho");
        Aluno a3 = new Aluno(3, "Clebson");
        
        alunos.add(a1);
        alunos.add(a2);
        alunos.add(a3);
        
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
        System.out.println("");
        // Expressão lambda ou Função anonima
        alunos.forEach(alunoDaVez -> {
            System.out.println(alunoDaVez.getNome());
        
        });
  
    }
}
