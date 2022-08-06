
package br.com.bandtec.mauricio.santana.c3;

import java.util.ArrayList;
import java.util.List;


public class ClinicaVeterinaria {
    
    private String nome;
    private Integer vagas;
    private List<VeterinarioClinico> veterinarios;

    public ClinicaVeterinaria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.veterinarios = new ArrayList();
    }
    
    public void contratarVeterinario(VeterinarioClinico veterinario) {
        if (veterinarios.size() < this.vagas) {
            veterinarios.add(veterinario);
        } else {
            System.out.println(String.format("A clínica %s não possuí vagas disponíveis", nome));
        }
    }
    
    public void exibirVeterinariosResidentes(){
        if (!this.veterinarios.isEmpty()) {
            veterinarios.forEach(veterinario -> System.out.println(veterinario));
        } else {
            System.out.println(String.format("A clínica %s não possuí veterinários", this.nome));
        }
    }
    
    public void exibirVeterinariosCirurgioesResidentes() {

        Integer veterinariosResidentesEncontrados = 0;

        if (!this.veterinarios.isEmpty()) {
            for (VeterinarioClinico veterinario : veterinarios) {
                if (veterinario instanceof VeterinarioCirurgiao) {
                    System.out.println(veterinario);
                    veterinariosResidentesEncontrados++;
                }
            }

            if (veterinariosResidentesEncontrados == 0) {
                System.out.println(String.format("A clínica %s não possuí veterinários", this.nome));
            }

        } else {
            System.out.println("");
        }
    }
    
        public void exibirFolhaDePagamento() {
           for (VeterinarioClinico veterinario : veterinarios) {
               System.out.println(veterinario.getNome());
               System.out.println(veterinario.calcularSalario());

           }
       }
//        
//        public String buscarVeterinario() {
//            // criar
//        }

    public String getNome() {
        return nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    @Override
    public String toString() {
        return "\nClinica:" +
                "\nNome: " + this.nome
                + "\nVagas: " + this.vagas
                + "\nVagas disponíveis: " + (this.vagas - veterinarios.size());
                
    }
}
    

