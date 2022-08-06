import java.util.ArrayList;
import java.util.List;

public class Tributo {

    // Atributo
    List<Tributavel> lista;

    // Construtor
    public Tributo() {
        lista = new ArrayList<Tributavel>();
    }

    // Métodos

    public void adicionaTributavel(Tributavel t) {
        lista.add(t);
    }

    public void exibirTodos() {
        System.out.println("\nLista dos itens tributáveis:");
        for(Tributavel t : lista) {
            System.out.println(t);
        }
    }

    public Double calculaTotalTributo() {
        Double total = 0.0;
        for (Tributavel t : lista) {
            total += t.getValorTributo();
        }
        return total;
    }


}
