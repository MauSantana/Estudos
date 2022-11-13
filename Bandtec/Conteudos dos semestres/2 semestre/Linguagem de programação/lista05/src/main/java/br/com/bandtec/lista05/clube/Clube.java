
package br.com.bandtec.lista05.clube;


public class Clube {
    private String time;
    private Integer vitoria;
    private Integer empate;
    private Integer derrota;
    private Integer pontos;
//    private Integer pontos;

    public Clube(String time) {
        
        this.time = time;
        this.vitoria = 0;
        this.empate = 0;
        this.derrota = 0;
        this.pontos = 0;
    }
    public Integer getVitoria() {
 
        return vitoria;
    }

    public Integer getEmpate() {
        return empate;
    }

    public Integer getDerrota() {
        return derrota;
    }
    
    public void RegistrarVitoria() {
        this.pontos += 3;
        this.vitoria += 1;
        System.out.println(String.format("--------------------------------\n"
                + "%s ganhou essa rodada\n"
                + "%s pontos: %d", this.time,this.time, this.pontos));
    }
    public void RegistrarEmpate() {
        this.pontos += 1;
        this.empate += 1;
        System.out.println(String.format("--------------------------------\n"
                + "%s empatou essa rodada\n"
                + "%s pontos: %d", this.time,this.time, this.pontos));
    }
        public void RegistrarDerrota() {
        this.derrota += 1;
        System.out.println(String.format("--------------------------------\n"
                + "%s perdeu essa rodada\n"
                + "%s pontos: %d", this.time,this.time, this.pontos));
    }
//    public void setVitoria(Integer vitoria) {
//
//        this.vitoria = vitoria;
//    }
//
//    public void setEmpate(Integer empate) {
//        this.empate = empate;
//    }
//
//    public void setDerrota(Integer derrota) {
//        this.derrota = derrota;
//    }

    @Override
    public String toString() {
        return "\nClube{" + "time=" + time + ", vitoria=" + vitoria + ", empate=" + empate + ", derrota=" + derrota + ", pontos=" + pontos + '}';
    }
    
    
}


