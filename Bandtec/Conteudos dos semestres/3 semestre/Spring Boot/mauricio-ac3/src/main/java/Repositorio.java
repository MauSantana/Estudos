import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repositorio {

    private int contador;

    private List<Jogador> listaJogadores;

    private PilhaObj<InfoUpdate> pilha;

    private FilaObj<Jogador> fila;

    public Repositorio() {
        this.listaJogadores = new ArrayList<>();
        this.pilha = new PilhaObj<InfoUpdate>(10);
        this.fila = new FilaObj<Jogador>(10);
        this.contador = 0;
    }

    public void save(Jogador jogador) {
        listaJogadores.add(jogador);
    }

    public void showAll() {
        if (listaJogadores.isEmpty()) {
            System.out.println("Lista vazia");
        }
        for (Jogador jogador : listaJogadores) {
            System.out.println(jogador);
        }
    }

    public Jogador capturarId(int id) {
        for (Jogador jogador : listaJogadores) {
            if (jogador.getId().equals(id)) ;
            return jogador;
        }
        return null;
    }

//    public void updateById(int id, Integer golsMarcados) {
//
//        InfoUpdate infoUpdate = new InfoUpdate (id, golsMarcados);
//        pilha.push(infoUpdate);
//        contador++;
//        for (int i = 0; i < listaJogadores.size(); i++) {
//            if (listaJogadores.get(id) == null){
//                System.out.println("ID invalido");
//            }
//            listaJogadores.get(i).getGolsMarcados().equals(golsMarcados);
//            System.out.println("Valor alterado");
//        }
//    }

        public void undo(int qtdOperacoes) {
            if (contador > 0) {
                for (int i = 0; i < qtdOperacoes; i++) {
                    System.out.println(String.format("O id:%d foi apagado", pilha.peek()));
                    listaJogadores.remove(capturarId(pilha.peek().getId()));
                    pilha.pop();
                    contador--;
                }
            }
        }


        public void flush() {
            if (!fila.isEmpty()) {
                for (int i = fila.peek().getId(); i > 0; i--) {
                    System.out.println(String.format("Sera apagado o id:%d", fila.peek()));
                    listaJogadores.remove(capturarId(fila.peek().getId()));
                    fila.poll();
                }
            } else {
                System.out.println("Não há operação a ser executada");
            }
        }

    public static void gravaRegistroDeJogadores(String registro, String nomeArq) {
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

    public static void gravaArquivoTxtJogadores(List<Jogador> listaJogadores, String nomeArq) {

        //Monta o registro de header
        String header = "00JOGADOR";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
        header += "01";


        //Grava o header
        gravaRegistroDeJogadores(header, nomeArq);


        Integer contaRegDados = 0;

        //Monta e grava o corpo
        for (Jogador m : listaJogadores) {
            String corpo = "02";
            corpo += String.format("%04d", m.getId());
            corpo += String.format("%-30s", m.getNome());
            corpo += String.format("%4.2f", m.getSalario());
            corpo += String.format("%04d", m.getNroJogos());
            corpo += String.format("%04d", m.getVitorias());
            corpo += String.format("%04d", m.getGolsMarcados());
            corpo += String.format("%-25s", m.getTime());

            contaRegDados++;

            gravaRegistroDeJogadores(corpo, nomeArq);
        }


        //Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%05d", contaRegDados);

        gravaRegistroDeJogadores(trailer, nomeArq);
    }


    public void exportTXT() {
        gravaArquivoTxtJogadores(listaJogadores, "jogadores.txt");
    }
}
