package br.com.bandtec.mauricio.santana.c2;

public class App {

    public static void main(String[] args) {

        Aluno a1 = new Aluno(2309, "Mauricio", true, false);
        Aluno a2 = new Aluno(7894, "Diego", true, false);
        Aluno a3 = new Aluno(1234, "João", true, false);

        a1.calcularMedia(3.7, 10.0);
        a2.calcularMedia(10.0, 10.0);
        a3.calcularMedia(5.2, 2.0);

        Secretaria s1 = new Secretaria();
        s1.registraPagamento(a1);
        s1.registraAtrasoPagamento(a2);
        s1.registraCancelamento(a3);

        s1.verificaAprovacaoAluno(a1);
        s1.verificaAprovacaoAluno(a2);
        s1.verificaAprovacaoAluno(a3);

        System.out.println(s1);

    }
}
