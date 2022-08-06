import javax.swing.*;

public class ExemploThrow {

    public static void main (String args[]) {
        float nota1 = Float.valueOf
                (JOptionPane.showInputDialog ("Digite a nota 1 (entre 0 e 10):"));
        float nota2 = Float.valueOf
                (JOptionPane.showInputDialog ("Digite a nota 2 (entre 0 e 10):"));

        try {
            if ((nota1 < 0) || (nota1 > 10)) {
                throw new LimiteUltrapassadoException("Nota1: Valor fora dos limites permitidos (entre 0 e 10)");
            }

            if ((nota2 < 0) || (nota2 > 10)) {
                throw new LimiteUltrapassadoException("Nota2: Valor fora dos limites permitidos (entre 0 e 10)");
            }

            JOptionPane.showMessageDialog (null, "Média =" + (nota1+nota2)/2);
        }
        catch (LimiteUltrapassadoException erro) {
            JOptionPane.showMessageDialog (null,String.format("%s\n%s", erro,erro.data));
        }

        System.exit(0);
    }
}  