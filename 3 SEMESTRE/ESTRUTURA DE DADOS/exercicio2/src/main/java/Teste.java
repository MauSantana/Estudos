public class Teste {

    public static void main(String[] args) {

        Coordenador c1 = new Coordenador("Sergio",5,10.0,
                8, 30.0);
        Professor p1 = new Professor("Carlos",60,7.0);
        ControleBonus cb1 = new ControleBonus();

        System.out.println("Exibir Bonus Coordenador: " + c1.getValorBonus());
        System.out.println("Exibir Bonus Professor: " + p1.getValorBonus());

        cb1.registrarBeneficiado(c1);
        cb1.registrarBeneficiado(p1);

        cb1.exibirBeneficiado();

        System.out.println("Exibir Bonus Total: " + cb1.calcularTotal());

    }


}
