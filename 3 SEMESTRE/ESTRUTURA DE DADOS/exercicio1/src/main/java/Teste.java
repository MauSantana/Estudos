public class Teste {

    public static void main(String[] args) {

Coordenador c1 = new Coordenador("Antonio",50,70.0);
Professor p1 = new Professor("Marta",20,200.0);

ControleBonus contBonus = new ControleBonus();

        System.out.println( "Bonus professor: " + p1.getValorBonus());
        System.out.println( "Bonus Coordenador: " + c1.getValorBonus());


        contBonus.registrarBeneficiado(c1);
        contBonus.registrarBeneficiado(p1);

        contBonus.exibirBeneficiado();

        System.out.println("Total do bonus: " + contBonus.calcularTotal());
    }
}
