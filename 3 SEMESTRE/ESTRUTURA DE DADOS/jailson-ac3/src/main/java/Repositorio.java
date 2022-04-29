import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repositorio {

    private List<Musicas> lista;

    private PilhaObj<Integer> pilha;

    private FilaObj<Integer> fila;

    private int contador;

    public Repositorio() {
        this.lista = new ArrayList<>();
        this.pilha = new PilhaObj<>(10);
        this.fila = new FilaObj<>(10);
        this.contador = 0;
    }

    public void save(Musicas musica) {
        lista.add(musica);
        pilha.push(musica.getId());
        contador++;
    }

    public void deleteById(int id) {
        if (pegarId(id) == null) {
            System.out.println("ID inválido");
        }
        lista.remove(pegarId(id));
        System.out.println("ID Deletado");
    }


    public void showAll() {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia");
        }
        for (Musicas jogos : lista) {
            System.out.println(jogos);
        }
    }


    public Musicas pegarId(int id) {
        for (Musicas musica : lista) {
            if (musica.getId().equals(id)) ;
            return musica;
        }
        return null;
    }

    public void undo(int qtdOperacoes) {
        if (contador > 0) {
            for (int i = 0; i < qtdOperacoes; i++) {
                System.out.println(String.format("Foi apagado o id:%d", pilha.peek()));
                lista.remove(pegarId(pilha.peek()));
                pilha.pop();
                contador--;
            }
        }
    }

    public void delayDeleteById(int id) {
        fila.insert(id);
    }

    public void flush() {
        if (!fila.isEmpty()) {
            for (int i = fila.getTamanho(); i > 0; i--) {
                System.out.println(String.format("Sera apagado o id:%d", fila.peek()));
                lista.remove(pegarId(fila.peek()));
                fila.poll();
            }
        } else {
            System.out.println("Não há operação a ser executada");
        }
    }

    public static void gravaRegistroDeMusicas(String registro, String nomeArq) {
        BufferedWriter saida = null;

        //Abre o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        //Grava o registro e fecha o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo: " + erro.getMessage());
        }

    }

    public static void gravaArquivoTxtMusicas(List<Musicas> lista, String nomeArq) {

        //Monta o registro de reader
        String header = "00MUSICAS";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
        header += "01";


        //Grava o header
        gravaRegistroDeMusicas(header, nomeArq);


        Integer contaRegDados = 0;

        //Monta e grava o corpo
        for (Musicas m : lista) {
            String corpo = "02";
            corpo += String.format("%04d", m.getId());
            corpo += String.format("%-30s", m.getNome());
            corpo += String.format("%4.2f", m.getNota());
            corpo += String.format("%-25s", m.getGenero());
            corpo += String.format("%07d", m.getQtdTocada());
            corpo += String.format("%07d", m.getQtdVendidaParaArtista());
            corpo += String.format("%07d", m.getQtdPlataformas());

            contaRegDados++;

            gravaRegistroDeMusicas(corpo, nomeArq);
        }


        //Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%05d", contaRegDados);

        gravaRegistroDeMusicas(trailer, nomeArq);
    }


    public void exportTXT() {
        gravaArquivoTxtMusicas(lista, "musicas.txt");
    }
}
