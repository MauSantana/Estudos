import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TesteGravaArquivoTxt {

    /* Método gravaRegistro - recebe um registro (String) e o nome do arquivo a ser gravado.
       Abre o arquivo, grava o registro e fecha o arquivo
     */
    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;    // objeto usado para gravar no arquivo

        // Abre o arquivo
        try {
            // Abre o arquivo com append = true, para poder ir acrescentando registros no arquivo
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        // Grava o registro e fecha o arquivo
        try {
            saida.append(registro + "\n");  // Grava o registro e o final de registro (\n)
            saida.close();                  // Fecha o arquivo
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar no arquivo: " + erro.getMessage());
        }
    }


    /* gravaArquivoTxt - recebe uma lista de Aluno e um nome de arquivo
       Grava o conteúdo da lista num arquivo com header, corpo e trailer, de acordo com o documento de layout
     */
    public static void gravaArquivoTxt(List<Aluno> lista, String nomeArq) {
        int contaRegDados = 0;      // contador de registros de dados (para poder gravar no trailer)

        // Monta o registro de header
        String header = "00NOTA20212";
        Date dataDeHoje = new Date();       // Data e hora do momento, no formato padrão do Java
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");     // configura o padrão de formatação da data e horário
        header += formataData.format(dataDeHoje);   // Formata a data e hora para o padrão desejado
        header += "01";

        // Grava o header
        gravaRegistro(header, nomeArq);

        // Monta e grava o corpo do arquivo
        for (Aluno a : lista) {
            // Monta o registro de corpo, de acordo com o especificado no documento de layout
            String corpo = "02";
            corpo += String.format("%-5.5s",a.getCurso());
            corpo += String.format("%-8.8s",a.getRa());
            corpo += String.format("%-50.50s",a.getNome());
            corpo += String.format("%-40.40s",a.getDisciplina());
            corpo += String.format("%05.2f",a.getMedia());
            corpo += String.format("%03d",a.getQtdFalta());
            // Incrementa o contador de registro de dados
            contaRegDados++;
            // Grava o registro de corpo no arquivo
            gravaRegistro(corpo, nomeArq);
        }

        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegDados);   // contador de registros de dados
        gravaRegistro(trailer, nomeArq);

    }

    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String ra, nome, curso, disciplina;
        Double media;
        int qtdFalta;
        int qtdRegistrosGravados;
        //int contaRegDados = 0; // vamos usar o size() da listaLida

        List<Aluno> listaLida = new ArrayList();

        // Abre o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        // Lê o arquivo
        try{
            // Lê o primeiro registro do arquivo
            registro = entrada.readLine();

            while (registro != null) { // enquanto não chegou ao fim do arquivo
                // Obtém os 2 primeiros caracteres do registro
                // Atenção, pois o substring considera que a string começa no índice zero (como um vetor)
                // Então para obter os 2 primeiros caracteres, passamos que começa no zero
                // E o substring recebe a posição final desejada + 1
                // Por isso chamamos substring(0, 2)
                //      012345
                //      00NOTA
                tipoRegistro = registro.substring(0, 2);

                if (tipoRegistro.equals("00")) {
                    System.out.println("Eh um registro de header");
                    System.out.println("Tipo de arquivo: "+registro.substring(2,6));
                    System.out.println("Ano/semestre: "+registro.substring(6,11));
                    System.out.println("Data/hora de gravação: "+registro.substring(11,30));
                    System.out.println("Versão do documento: "+registro.substring(30,32));
                }
                else  if (tipoRegistro.equals("01")) {
                    System.out.println("Eh um registro de trailer");
                    qtdRegistrosGravados = Integer.valueOf(registro.substring(2, 12));
                    // Validação se a quantidade de registros que está no trailer é igual à
                    // quantidade lida de registros
                    if (qtdRegistrosGravados == listaLida.size()) {
                        System.out.println("Quantidade de registros gravados compatível com quantidade lida");
                    }
                    else {
                        System.out.println("Quantidade de registros gravados não confere com quantidade lida");
                    }
                }
                else  if (tipoRegistro.equals("02")) {
                    System.out.println("Eh um registro de corpo");
                    curso = registro.substring(2,7).trim();     // o trim() remove os brancos à direita
                    ra = registro.substring(7,15);
                    nome = registro.substring(15,65).trim();
                    disciplina = registro.substring(65,105).trim();
                    // Para converter para Double, precisamos substituir a ',' por '.'
                    media = Double.valueOf(registro.substring(105,110).replace(',','.'));
                    qtdFalta = Integer.valueOf(registro.substring(110,113));
                    // Criamos um objeto com os atributos lidos do registro de corpo
                    Aluno a = new Aluno(ra, nome, curso, disciplina, media, qtdFalta);
                    // Adicionamos esse objeto à listaLida
                    listaLida.add(a);
                    //contaRegDados++;
                }
                else {
                    System.out.println("Tipo de registro inválido!");
                }

                // Lê o próximo registro
                registro = entrada.readLine();

            }
            entrada.close();    // Fecha o arquivo
        }
        catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo: " + erro.getMessage());
        }

        // Exibe o conteúdo da listaLida
        System.out.println("\nConteúdo lido do arquivo:");
        for (Aluno a : listaLida) {
            System.out.println(a);
        }
    }


    public static void main(String[] args) {
        // Criação de objetos Aluno
        Aluno a1 = new Aluno("01202111","Maria Sousa","ADS",
                            "Banco de Dados",9.0,7);
        Aluno a2 = new Aluno("01202122","João Teixeira","ADS",
                "Análise de Sistemas",7.5,8);
        Aluno a3 = new Aluno("01202133","Ana Tavares","REDES",
                "Cabeamento Estruturado",6.5,10);
        Aluno a4 = new Aluno("01202144","Mário Lopes","CCO",
                "Cálculo e Estatística",10.0,0);

        // Criação de uma lista para armazenar os alunos
        List<Aluno> lista = new ArrayList();

        // Adicionando os alunos à lista
        lista.add(a1);
        lista.add(a2);
        lista.add(a3);
        lista.add(a4);

        // Grava o conteúdo da lista num arquivo txt
        gravaArquivoTxt(lista, "alunos.txt");

        // Lê o arquivo txt
        leArquivoTxt("alunos.txt");
    }
}
