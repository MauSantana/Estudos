
public class App {
    public static void main(String[] args) {

        System.out.println("\n\n\n----------------------------------------------------------------------------------");
        System.out.println("------------------------------PROFESSORES x ALUNOS--------------------------------");
        System.out.println("----------------------------------------------------------------------------------\n\n\n");

        System.out.println(". . . Instanciando Professores . . .\n");

        // instanciando professores:
        Professor prof1 = new Professor("célia", "banco de dados");
        Professor prof2 = new Professor("alex", "análise de sistemas");

        System.out.println(". . . Instanciando Alunos . . .\n");

        // instanciando alunos:
        Aluno aluno1 = new Aluno("ana", "01202-0AB0", "banco de dados");
        Aluno aluno2 = new Aluno("bruno", "01202-0AB1", "banco de dados");
        Aluno aluno3 = new Aluno("carol", "01202-0AB2", "análise de sistemas");
        Aluno aluno4 = new Aluno("douglas", "01202-0AB3", "análise de sistemas");

        System.out.println("\n\nOS PROFESSORES SÃO:");
        System.out.println(prof1.toString());
        System.out.println(prof2.toString());

        System.out.println("\n\nOS ALUNOS SÃO:");
        System.out.println(aluno1.toString());
        System.out.println(aluno2.toString());
        System.out.println(aluno3.toString());
        System.out.println(aluno4.toString());

        System.out.println("\n\n\n . . . Adicionando cada aluno(a) ao seu professor . . .");

        prof1.addAluno(aluno1);
        prof1.addAluno(aluno2);
        prof2.addAluno(aluno3);
        prof2.addAluno(aluno4);

        System.out.println("\n\nOS PROFESSORES E SEUS RESPECTIVOS ALUNOS:");
        System.out.println(prof1.toString());
        System.out.println(prof2.toString());

        System.out.println("\n\n\n----------------------------------------------------------------------------------");
        System.out.println("-----------------------------------LOGIN CELIA------------------------------------");
        System.out.println("----------------------------------------------------------------------------------\n\n\n");

        // mensagem - inicio prof 1
        System.out.println("\n\n\n . . . Professor "+prof1.getNome()+" entrou no sistema.");
        System.out.println("\nOs alunos do professor " + prof1.getNome() + " são: \n"+ prof1.getMeusAlunos());
        System.out.println("\n . . . lançando faltas aos alunos . . . \n");

        // prof1 lança faltas
        prof1.lancarFaltas(aluno1, 1);
        prof1.lancarFaltas(aluno2, 2);
        prof1.lancarFaltas(aluno3, 3);
        prof1.lancarFaltas(aluno4, 4);

        System.out.println("\n . . . lançando notas aos alunos . . . \n");

        // prof1 lança notas
        prof1.lancarNota(aluno1, 9.0);
        prof1.lancarNota(aluno2, 8.0);
        prof1.lancarNota(aluno3, 7.0);
        prof1.lancarNota(aluno4, 6.0);

        // mensagem - fim prof 1
        System.out.println("\n Professor "+prof1.getNome()+" saiu do sistema . . .");

        System.out.println("\n\n\n-----------------------------------------------------------------------------------");
        System.out.println("-----------------------------------LOGIN ALEX-------------------------------------");
        System.out.println("----------------------------------------------------------------------------------\n\n\n");

        // mensagem - inicio prof 2
        System.out.println("\n\n\n . . . Professor "+prof2.getNome()+" entrou no sistema.");
        System.out.println("\nOs alunos do professor " + prof2.getNome() + " são: "+ prof2.getMeusAlunos());
        System.out.println("\n . . . lançando faltas aos alunos . . . \n");

        // prof2 lança faltas
        prof2.lancarFaltas(aluno1, 1);
        prof2.lancarFaltas(aluno2, 2);
        prof2.lancarFaltas(aluno3, 3);
        prof2.lancarFaltas(aluno4, 4);
        System.out.println("\t\tVerificando que faltas são realmente SOMADAS");
        prof2.lancarFaltas(aluno4, 4);

        System.out.println("\n . . . lançando notas aos alunos . . . \n");

        // prof1 lança notas
        prof2.lancarNota(aluno1, 9.0);
        prof2.lancarNota(aluno2, 8.0);
        prof2.lancarNota(aluno3, 7.0);
        prof2.lancarNota(aluno4, 6.0);
        System.out.println("\t\tVerificando que notas são realmente SUBSTITU�?DAS");
        prof2.lancarNota(aluno4, 5.0);

        // mensagem - fim prof 2
        System.out.println("\n Professor "+prof2.getNome()+" saiu do sistema . . .");

        // imprimindo lista de alunos, agora com faltas
        System.out.println("\n\nOS ALUNOS ESTÃO COMO ABAIXO:");
        System.out.println(aluno1.toString());
        System.out.println(aluno2.toString());
        System.out.println(aluno3.toString());
        System.out.println(aluno4.toString());
    }
}
