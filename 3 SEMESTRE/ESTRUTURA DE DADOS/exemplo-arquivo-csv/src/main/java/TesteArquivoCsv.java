import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TesteArquivoCsv {

    public static void gravaArquivoCsv (ListaObj<Cachorro> lista, String nomeArq) {
        FileWriter arq = null;     // objeto que representa o arquivo a ser gravado
        Formatter saida = null;    // objeto que usaremos para escrever no arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";         // acrescenta a extensão .csv ao nome do arquivo

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArq,false);   // abre o arquivo nomeArq
            saida = new Formatter(arq);     // associa o objeto saida ao arquivo
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        // Bloco try-catch para percorrer a lista e gravar no arquivo
        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Cachorro dog = lista.getElemento(i);
                saida.format("%d;%s;%s;%.1f\n",dog.getId(), dog.getNome(),
                                              dog.getPorte(), dog.getPeso());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar no arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leExibeArquivoCsv (String nomeArq) {
        FileReader arq = null;  // objeto que representa o arquivo para leitura
        Scanner entrada = null; // objeto usado para ler do arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            /* Cria o objeto do Scanner, informando que o delimitador é
               o ';' OU o '\n'  */
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        // Bloco try-catch para ler do arquivo
        try {
            System.out.printf("%4s %-15s %-9s %5s\n", "ID", "NOME", "PORTE", "PESO");
            while (entrada.hasNext()) {  //enquanto não for final do arquivo
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                String porte = entrada.next();
                Double peso = entrada.nextDouble();
                System.out.printf("%4d %-15s %-9s %5.2f\n", id, nome, porte, peso);
            }
        }
        catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }

    }



    public static void main(String[] args) {
        ListaObj<Cachorro> lista = new ListaObj(7);

        lista.adiciona(new Cachorro(1, "Flash", "Pequeno", 3.0));
        lista.adiciona(new Cachorro(2, "Cafe com leite", "Pequeno", 10.0));
        lista.adiciona(new Cachorro(3, "Toco", "Grande", 15.0));
        lista.adiciona(new Cachorro(4, "Sexta feira", "Médio", 8.0));
        lista.adiciona(new Cachorro(5, "Wendy", "Pequeno", 3.0));
        lista.adiciona(new Cachorro(6, "Anderson", "Grande", 5.0));

        lista.exibe();

        gravaArquivoCsv(lista, "dogs");

        leExibeArquivoCsv("dogs");
    }
}
