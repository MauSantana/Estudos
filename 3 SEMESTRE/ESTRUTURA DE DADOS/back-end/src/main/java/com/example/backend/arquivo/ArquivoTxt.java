package com.example.backend.arquivo;

import com.example.backend.dominio.Psicologo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArquivoTxt {

    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar no arquivo: " + erro.getMessage());
        }
    }

    public static void gravaArquivoTxt(List<Psicologo> lista, String nomeArq) {
        int contaRegDados = 0;

        String header = "00PSICOLOGOS20212";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
        header += "01";

        gravaRegistro(header, nomeArq);

        for (Psicologo p : lista) {
            String corpo = "02";
            corpo += String.format("%-20.20s ",p.getNome());
            corpo += String.format("%11.11s ",p.getCpf());
            corpo += String.format("%-20.20s ",p.getEmail());
            corpo += String.format("%11.11s ",p.getTelefone1());
            corpo += String.format("%11.11s ",p.getTelefone2());
            corpo += String.format("%15.15s ",p.getNumeroDoCrp());
            contaRegDados++;
            gravaRegistro(corpo, nomeArq);
        }
        String trailer = "01";
        trailer += String.format("%010d", contaRegDados);
        gravaRegistro(trailer, nomeArq);

    }

    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String nome, cpf, email, telefone1, telefone2, numeroCrp;
        int qtdRegistrosGravados;

        List<Psicologo> listaLida = new ArrayList();

        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        try{
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0, 2);

                if (tipoRegistro.equals("00")) {
                    System.out.println("É um registro de header!");
                    System.out.println("Tipo de arquivo: "+registro.substring(2,19));
                    System.out.println("Data/hora de gravação: "+registro.substring(19,39));
                    System.out.println("Versão do documento: "+registro.substring(39,41));
                }
                else  if (tipoRegistro.equals("01")) {
                    System.out.println("É um registro de trailer");
                    qtdRegistrosGravados = Integer.valueOf(registro.substring(2, 18));
                    if (qtdRegistrosGravados == listaLida.size()) {
                        System.out.println("Quantidade de registros gravados compatível com quantidade lida");
                    }
                    else {
                        System.out.println("Quantidade de registros gravados não confere com quantidade lida");
                    }
                }
                else  if (tipoRegistro.equals("02")) {
                    System.out.println("Eh um registro de corpo!");
                    nome = registro.substring(2,63).trim();
                    cpf = registro.substring(63,74);
                    email = registro.substring(74,114).trim();
                    telefone1 = registro.substring(114,125).trim();
                    telefone2 = registro.substring(125,136).trim();
                    numeroCrp = registro.substring(136,151).trim();
                    Psicologo p = new Psicologo(nome, cpf, email, telefone1, telefone2, numeroCrp);
                    listaLida.add(p);
                    //contaRegDados++;
                }
                else {
                    System.out.println("Tipo de registro inválido!");
                }
                registro = entrada.readLine();

            }
            entrada.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo: " + erro.getMessage());
        }

        System.out.println("\nConteúdo lido do arquivo:");
        for (Psicologo p : listaLida) {
            System.out.println(p);
        }
    }

}
