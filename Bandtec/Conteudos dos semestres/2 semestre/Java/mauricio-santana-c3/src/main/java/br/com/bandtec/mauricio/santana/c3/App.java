
package br.com.bandtec.mauricio.santana.c3;


public class App {
    
    public static void main(String[] args) {
        
        VeterinarioClinico vcli1 = new VeterinarioClinico (123, "Marcos", 5, 50.0);
        VeterinarioClinico vcli2 = new VeterinarioClinico (124, "Jorge", 8, 10.0);
        VeterinarioClinico vcli3 = new VeterinarioClinico (125, "Antonio", 9, 50.0);
        VeterinarioClinico vcli4 = new VeterinarioClinico (126, "Roberto", 3, 100.0);
        
        VeterinarioCirurgiao vcir1 = new VeterinarioCirurgiao (300, "José", 4, 60.0, 0, 0.0);
        VeterinarioCirurgiao vcir2 = new VeterinarioCirurgiao (301, "Claudio", 10, 80.0, 0, 0.0);
        
        ClinicaVeterinaria cli1 = new ClinicaVeterinaria("Cruz vermelha", 3);
        
        cli1.exibirVeterinariosResidentes();
        System.out.println("");
        cli1.contratarVeterinario(vcli1);
        cli1.contratarVeterinario(vcli2);
        cli1.contratarVeterinario(vcli3);
        cli1.contratarVeterinario(vcli4);
        cli1.contratarVeterinario(vcir1);
        cli1.contratarVeterinario(vcir2);
        System.out.println("");

        cli1.exibirVeterinariosResidentes();
        System.out.println("");

        cli1.exibirVeterinariosCirurgioesResidentes();
        System.out.println("");
        
        System.out.println(cli1);
        System.out.println("");
        
        System.out.println("Folha de pagamento:");
        cli1.exibirFolhaDePagamento();
        
        
    }
}
