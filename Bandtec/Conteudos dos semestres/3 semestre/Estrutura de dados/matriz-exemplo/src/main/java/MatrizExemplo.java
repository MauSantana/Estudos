import java.util.Scanner;

public class MatrizExemplo {
    public static void main(String[] args) {
        System.out.println("APRENDENDO MATRIZ!");

        Scanner leitor = new Scanner(System.in);

        int[] vetor = new int[3]; //vetor
        int[][] matriz = new int[3][4]; //matriz
        int[][] matrizInicializada = {{1,2},{3,4},{5,6},{7,8}};
        int[][] matrizIrregularInicializada = {{1}, {2,3,4}, {5,6}, {7,8,9,10}};

        int[][] matrizIrregular = new int[4][];
        matrizIrregular[0] = new int[1];
        matrizIrregular[1] = new int[3];
        matrizIrregular[2] = new int[2];
        matrizIrregular[3] = new int[4];

        System.out.println("Irregular inicializada");
        exibirMatriz(matrizIrregularInicializada);

        System.out.println("\nMatriz inicializada");
        exibirMatriz(matrizInicializada);

        for (int linha = 0; linha < matriz.length; linha++){
            for (int coluna = 0; coluna < matriz[linha].length; coluna++){
                System.out.println(
                        "Digite o valor de [" + linha + "][" + coluna + "]");
                matriz[linha][coluna] = leitor.nextInt();
            }
        }

        System.out.println("MATRIZ");
        exibirMatriz(matriz);
        System.out.println("MATRIZ TRANSPOSTA");
        exibirMatrizTransposta(matriz);

    }

    public static void exibirMatriz(int[][] m){
        for (int linha = 0; linha < m.length; linha++){
            for (int coluna = 0; coluna < m[0].length; coluna++){
                System.out.print(m[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }

    public static void exibirMatrizTransposta(int[][] m){
            for (int coluna = 0; coluna < m[0].length; coluna++){
                for (int linha = 0; linha < m.length; linha++){
                    System.out.print(m[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }

}
