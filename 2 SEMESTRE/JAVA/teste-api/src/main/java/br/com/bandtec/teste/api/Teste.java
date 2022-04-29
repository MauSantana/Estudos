
package br.com.bandtec.teste.api;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;

public class Teste {
    public static void main(String[] args) {
        
        Looca looca = new Looca();
        
        Sistema sistema = looca.getSistema();
        
        System.out.println(sistema);
        
    }
}
