
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jeanmarioml
 */
public class SJF {
    
        //Estados
    private static final int PRONTO = 1;
    private static final int EXECUTANDO = 2;
    private static final int ESPERA  = 3;
    
    LOGS log;
    
    private int time = 0;
    private int tempoProcessMedio = 0;
    private int tempoEsperaMedio = 0;
    
    ArrayList<PCB> espera;
    ArrayList<PCB> executando;
    ArrayList<PCB> pronto;
    ArrayList<PCB> processos;
    
    public SJF(){
        this.pronto = new ArrayList();
        this.processos = new ArrayList();
        this.time = 0;
    }
    

    public ArrayList<PCB> getEspera() {
        return espera;
    }

    public void setEspera(ArrayList<PCB> espera) {
        this.espera = espera;
    }

    public ArrayList<PCB> getPronto() {
        return pronto;
    }

    public void setPronto(ArrayList<PCB> pronto) {
        this.pronto = pronto;
    }

    public ArrayList<PCB> getProcessos() {
        return processos;
    }

    public void setProcessos(ArrayList<PCB> processos) {
        this.processos = processos;
    }
    
    

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    
    
    public void ordenaListaProntos(){
        
        for(int i = 0; i < pronto.size(); i++){
            for(int j = i; j < pronto.size(); j++){
                if((pronto.get(i).getPicos()).get(0) > (pronto.get(j).getPicos()).get(0)){
                    PCB aux = new PCB(pronto.get(i));
                    pronto.set(i, pronto.get(j));
                    pronto.set(j,aux);
                }
            }
        }
        
       
    }
    
    public void getProcesso(){
        int lacunas = 10-pronto.size();
        System.out.println("lacunas: "+lacunas);
        for(int i = 0; i < lacunas; i++){
            if(processos.get(i).getTempoChegada() <= time){
                pronto.add(processos.get(i));
            }
        }
    }
    
    public void removeProcessos(){
        for(int i = 0; i < 10; i++){
            processos.remove(0);
          //  Thread.sleep(100);
        }
    }
    
    public PCB getProcesso2(){
            if(!processos.isEmpty()){
                if(processos.get(0).getTempoChegada() <= time){
                   // pronto.add(processos.get(0));
                    PCB example = new PCB(processos.get(0));
                    processos.remove(0);
                    return example;
                    
                }
            }
            return null;
         
    }
    
    public void executaProcessos() throws InterruptedException{

        int tempoProcess = 0;
        int tamanhoPico = 0;
        while(true){
            for(int i = 0; i < pronto.size(); i++){
                tempoProcess = 0;
                if(!pronto.get(i).getPicos().isEmpty()){
                    for(int j = 0; j < pronto.get(i).getnPicos(); j++){
                        tamanhoPico = pronto.get(i).getPicos().get(j);
                        for(int l = 0; l < tamanhoPico; l++){
                            time++; //unidades de tempo para cada pico
                            tempoProcess++;
                            tempoProcessMedio += tempoProcess;
                         
                        }
                        
                    }
                    System.out.println("Processo "+pronto.get(i).getIdProcesso()+" Tempo de Execucao: "+tempoProcess);
                }
                
            }
            System.out.println("Tempo total: "+time);
            break;
        }
    }
    
    public void executaProcessos2() throws IOException{
        removeProcessos();
        int tempoProcess = 0;
        int tamanhoPico = 0;
        int teste = 0;
        while(!pronto.isEmpty()){
                if(teste == 1){
                pronto.add(getProcesso2());
                }
                teste = 1;
                
                ordenaListaProntos();
               // System.out.println("Proximo processo: "+pronto.get(0).getIdProcesso());
                tempoProcess = 0;
                pronto.get(0).setTempoEspera((int) (time - pronto.get(0).getTempoChegada()));
                pronto.get(0).setTempoServico(10*pronto.get(0).getnPicos());
                tempoEsperaMedio += pronto.get(0).getTempoEspera();
                    for(int j = 0; j < pronto.get(0).getnPicos(); j++){
                        tamanhoPico = pronto.get(0).getPicos().get(j);
                        for(int l = 0; l < tamanhoPico; l++){
                            time++; //unidades de tempo para cada pico
                            tempoProcess++;
                            tempoProcessMedio += tempoProcess;
                            if(time%200 == 0){
                               // log.geraLog2(pronto.size(),processos.size(),pronto.get(0).getIdProcesso());
                            }
                         
                        }
                        
                    }
                    pronto.get(0).setTempoFinalizacao(time);
                    System.out.println("Processo "+pronto.get(0).getIdProcesso()+" Tempo de Processamento: "+tempoProcess);
                   //log.geraLog1((int)pronto.get(0).getIdProcesso(),(int)pronto.get(0).getTempoChegada(),(int)pronto.get(0).getTempoFinalizacao(),(int)tempoProcess,(int)pronto.get(0).getTempoEspera());
        if(pronto.get(0).getIdProcesso() == 999){
        pronto.remove(0);
        break;
        }    
        pronto.remove(0);
        //Thread.sleep(10);
        //System.out.println("Proximo processo: "+pronto.get(0).getIdProcesso());

        
        }
        System.out.println("Tempo total: "+time);
        log.geraLog3(time,tempoProcessMedio,tempoEsperaMedio);
    }
    
    public void executaProcessos3() throws InterruptedException{
        removeProcessos();
        int tempoProcess = 0;
        int tamanhoPico = 0;
        int teste = 0;
        while(!pronto.isEmpty()){
                if(teste == 1){
                pronto.add(getProcesso2());
                }
                teste = 1;
                
                ordenaListaProntos();
               // System.out.println("Proximo processo: "+pronto.get(0).getIdProcesso());
                tempoProcess = 0;
                    for(int j = 0; j < pronto.get(0).getnPicos(); j++){
                        tamanhoPico = pronto.get(0).getPicos().get(j);
                        for(int l = 0; l < tamanhoPico; l++){
                            time++; //unidades de tempo para cada pico
                            tempoProcess++;
                         
                        }
                        
                    }
                    System.out.println("Processo "+pronto.get(0).getIdProcesso()+" Tempo de Execucao: "+tempoProcess);
                
        if(pronto.get(0).getIdProcesso() == 999){
        pronto.remove(0);
        break;
        }    
        pronto.remove(0);
        //Thread.sleep(10);
        //System.out.println("Proximo processo: "+pronto.get(0).getIdProcesso());

        
        }
        System.out.println("Tempo total: "+time);
    }
}
