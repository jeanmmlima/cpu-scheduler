
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jeanmarioml
 */
public class TestLeituraProc {
    
    
     public static void main(String[] args) throws IOException{
         LENDODAT ler = new LENDODAT();
         ler.processos();
         SJF sjf = new SJF();
         //PCB exemplo = new PCB(10,10,10);
         
         
         sjf.setProcessos(ler.getProcess());
         
         for(int i = 0; i < sjf.getProcessos().size(); i++){
            System.out.print((sjf.getProcessos().get(i)).getIdProcesso()+" ");
            System.out.print((sjf.getProcessos().get(i)).getTempoChegada()+" ");
            System.out.print((sjf.getProcessos().get(i)).getnPicos()+" ");
            for(int j = 0; j < (sjf.getProcessos().get(i)).getnPicos(); j++){
                System.out.print((sjf.getProcessos().get(i)).getPicos().get(j)+" ");
            }
            System.out.println("");
         }
         
         
         sjf.getProcesso();
         
        // System.out.println("Tamanho de prontos: "+sjf.getPronto().size());
         
         System.out.println("--------- TESTE 1: PROCESSOS PRONTOS --------");
         
         for(int i = 0; i < sjf.getPronto().size(); i++){
            System.out.print((sjf.getPronto().get(i)).getIdProcesso()+" ");
            System.out.print((sjf.getPronto().get(i)).getTempoChegada()+" ");
            System.out.print((sjf.getPronto().get(i)).getnPicos()+" ");
            for(int j = 0; j < (sjf.getPronto().get(i)).getnPicos(); j++){
                System.out.print((sjf.getPronto().get(i)).getPicos().get(j)+" ");
            }
            System.out.println("");
         }
         
         
         sjf.ordenaListaProntos();
         
         System.out.println("--------- TESTE 2: PROCESSOS ORDENADOS POR TEMPO MAIS CURTO --------");
         
          for(int i = 0; i < sjf.getPronto().size(); i++){
            System.out.print((sjf.getPronto().get(i)).getIdProcesso()+" ");
            System.out.print((sjf.getPronto().get(i)).getTempoChegada()+" ");
            System.out.print((sjf.getPronto().get(i)).getnPicos()+" ");
            for(int j = 0; j < (sjf.getPronto().get(i)).getnPicos(); j++){
                System.out.print((sjf.getPronto().get(i)).getPicos().get(j)+" ");
            }
            System.out.println("");
         }
         
         PCB exemplo = new PCB(sjf.getPronto().get(0));
         System.out.println("Menor pico: "+exemplo.getPicos().get(0));
         
         for(int i = 0; i < exemplo.getPicos().size(); i++){
             System.out.println("Picos: "+exemplo.getPicos().get(i));
         }
         
         sjf.executaProcessos2();
         
     }
    
}
