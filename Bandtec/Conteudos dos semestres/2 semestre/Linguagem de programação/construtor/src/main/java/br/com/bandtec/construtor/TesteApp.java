
package br.com.bandtec.construtor;


public class TesteApp {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("mau", "ads");
        Aluno aluno2 = new Aluno("sant", "rh");
        
//        aluno1.setNome("Mau");
//        aluno1.setCurso("ADS");
//        aluno1.setFaltas(5);
//        aluno1.setNotaFinal(10.0);
//        
//        aluno2.setNome("Santana");
//        aluno2.setCurso("ADS");
//        aluno2.setFaltas(4);
//        aluno2.setNotaFinal(8.0);

        System.out.println(aluno1);
        System.out.println(aluno2);
        
//        System.out.println(String.format("Nome:%s \nCurso: %s\n Faltas: %d\n"
//                + "Nota: %.2f", aluno1.getNome(), aluno1.getCurso(),
//                aluno1.getFaltas(), aluno1.getNotaFinal()));
//        
//        System.out.println(String.format("Nome:%s \nCurso: %s\n Faltas: %d\n"
//                + "Nota: %.2f", aluno2.getNome(), aluno2.getCurso(),
//                aluno2.getFaltas(), aluno2.getNotaFinal()));        
    }
}
