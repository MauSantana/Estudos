public class SaidaFormatada {

    public static void main(String[] args) {
        String nome1 = "Célia";
        String nome2 = "Manoel";
        Integer ra1 = 5001;
        Integer ra2 = 5002;
        Double nota1 = 8.5;
        Double nota2 = 9.0;

        System.out.printf("---------------------------------------\n");
        System.out.printf("%-7s %-14s %5s\n", "RA", "NOME", "NOTA");
        System.out.printf("%07d %-14s %05.2f\n", ra1, nome1, nota1);
        System.out.printf("%07d %-14s %05.2f\n", ra2, nome2, nota2);
    }
}
