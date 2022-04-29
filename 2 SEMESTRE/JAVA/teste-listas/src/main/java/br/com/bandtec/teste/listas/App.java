
package br.com.bandtec.teste.listas;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        
//        String[] vetor = new String[3];
//
//        vetor[0] = "Mauricio";
//        vetor[1] = "Santana";
//        vetor[2] = "Santos";
//        
//        for (int i = 0; i < vetor.length; i++) {
//            System.out.println(vetor[i]);
//        }

//        List listaLoka = new ArrayList();
//        
//        listaLoka.add("mauricio");
//        listaLoka.add(19);
//        listaLoka.add(1.85);
//        listaLoka.add(true);
//        
//        System.out.println(listaLoka);

        List<String> nomes = new ArrayList();
        List<Integer> numeros = new ArrayList();
        
        nomes.add("Mau");
        nomes.add("Ted");
        nomes.add("Barney");
        
        System.out.println(nomes);
        
        nomes.add(0, "Robin");
        
        System.out.println(nomes);
        
        nomes.add(0, "Marshall");
        
        System.out.println(nomes);
        
        nomes.set(0, "Tracy");
        
        System.out.println(nomes);
        
        nomes.clear();
        
        System.out.println(nomes);
        
        if (nomes.isEmpty()) {
            System.out.println("Não tem registro");
        }else {
            System.out.println("Tem registro");
        }
        
    }
}
