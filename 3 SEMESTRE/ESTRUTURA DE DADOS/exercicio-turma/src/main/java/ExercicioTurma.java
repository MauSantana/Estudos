import java.util.Scanner;

public class ExercicioTurma {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String[] vetorT1 = new String[10];
        String[] vetorT2 = new String[10];
        String nomeAluno;
        String turma;
        Integer indT1 = 0,  /* representa quantos alunos tem no vetorT1
                               e tb o índice onde será colocado um novo aluno no vetorT1 */
                indT2 = 0;  /* representa quantos alunos tem no vetorT2
                               e tb o índice onde será colocado um novo aluno no vetorT2 */

        /* Loop para ler os nomes e as turmas de 10 alunos */
        for (int i = 0; i < 10; i++) {
            System.out.println("Digite o nome de um aluno");
            nomeAluno = leitor.next();

            /* validação do nome da turma - fica em loop até que o usuário
               digite turma T1 ou T2
             */
            do {
                System.out.println("Digite a turma do aluno (T1 ou T2)");
                turma = leitor.next();
            } while (!turma.equalsIgnoreCase("T1") &&
                     !turma.equalsIgnoreCase("T2"));

            if (turma.equalsIgnoreCase("T1")) {
                vetorT1[indT1++] = nomeAluno;   /* Turma T1 - coloca o nome do aluno
                                                   no vetorT1, no índice indT1
                                                   e incrementa indT1 */
            }
            else {
                vetorT2[indT2++] = nomeAluno;   /* Turma T2 - coloca o nome do aluno
                                                   no vetorT2, no índice indT2
                                                   e incrementa indT2 */

            }
        }

        // Exibe se há alunos na turma T1 ou não e quais são os alunos
        if (indT1 == 0) {
            System.out.println("Não há alunos na turma T1");
        }
        else {
            System.out.println("Há " + indT1 + " alunos na turma T1");
            for (int i = 0; i < indT1; i++) {
                System.out.print(vetorT1[i] + "\t");
            }
            System.out.println();
        }

        // Exibe se há alunos na turma T2 ou não e quais são os alunos
        if (indT2 == 0) {
            System.out.println("Não há alunos na turma T2");
        }
        else {
            System.out.println("Há " + indT2 + " alunos na turma T2");
            for (int i = 0; i < indT2; i++) {
                System.out.print(vetorT2[i] + "\t");
            }
            System.out.println();
        }


    }
}
