/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.ac3.so;


import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.servicos.Servico;
import com.github.britooo.looca.api.group.servicos.ServicosGroup;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.sun.jna.platform.win32.Sspi;
import com.sun.jna.platform.win32.Sspi.TimeStamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


public class Recurso {

    Looca looca = new Looca();

    private String momento;
    private String consumoRam;
    private Double consumoCpu;
    private String consumoDisco;

    public Recurso() {
        this.consumoRam = looca.getMemoria().getEmUso().toString();
        this.consumoCpu = looca.getProcessador().getUso();
        this.consumoDisco = looca.getGrupoDeDiscos().getDiscos().toString();
    
    }

    public String getMomento() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
         LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

 

    public Double getConsumoRam() {
        Long ramTotal = looca.getMemoria().getTotal();
        Long ramDisponivel = looca.getMemoria().getDisponivel();
        Double percentualMemoriaEmUso = (double) (ramTotal - ramDisponivel) / ramTotal * 100;
        return percentualMemoriaEmUso;
    }

 

    public Double getConsumoDisco() {
        Long discoTotal = looca.getGrupoDeDiscos().getTamanhoTotal();
        Long discoDisponivel = looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel();
        Double percentualDiscoEmUso = (double) (discoTotal - discoDisponivel) / discoTotal * 100;
        return percentualDiscoEmUso;
    }
    
    public Double getConsumoCPU() {
        return this.consumoCpu;
    }
}

