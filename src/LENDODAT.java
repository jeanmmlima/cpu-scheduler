
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class LENDODAT {
    
    private ArrayList<PCB> process;
    private PCB[] example;
    private String s;
    private String[] linhas;
    private String dados;
    private int indexLinhas;
    private ArrayList<Integer>[] picos;
    
    public LENDODAT(){
        process = new ArrayList();
        example = new PCB[1000];
        linhas = new String[1000];
        picos = new ArrayList[1000];
        for(int i = 0; i < 1000; i++){
            picos[i] = new ArrayList();
        }
        s = "";
        dados = "";
        indexLinhas = 0;
        
    }

    public ArrayList<PCB> getProcess() {
        return process;
    }
    
    
    
    public void processos(){
        String dados = "";
        String nomeArquivo="processos.dat"; 
        String linha="";
        File arquivo = new File(nomeArquivo);
        String nPicos;
        String idPicos;
        String tempoChegadaPross;
        String pico;
        int start;
        int numPicos;
        int indexPicos;
        
 
        //Verifica a existencia do arquivo
        if (arquivo.exists()){
          System.out.println("Arquivo - '"+nomeArquivo+"', aberto com sucesso!\n");
          System.out.println("Tamanho do arquivo "+Long.toString(arquivo.length())+"\n");
     
        try{
        //abrindo arquivo para leitura
            FileReader reader = new FileReader(nomeArquivo);
       
            BufferedReader bufferReader = new BufferedReader(reader);
            while(true){
             linha=bufferReader.readLine();
             if(linha==null)
               break;
             dados+=linha+"\n";
            }
      
        reader.close();
      
        } 
        catch(Exception erro) {}
        //System.out.println(dados);
        s = dados;
        }
        else{
         System.out.println("NAO ACHOU O ARQUIVO");
        }
        dados = "";
        for(int i = 0; i < s.length(); i++){
          if(indexLinhas < 1000){
            if(s.charAt(i) != '\n'){
                dados += s.charAt(i);
            }
            else if(s.charAt(i) == '\n'){
                linhas[indexLinhas] = dados;
                dados = "";
                indexLinhas++;
            }
          }
          
      }
        for(int i = 0; i < 1000; i++){
            example[i] = new PCB(10,10,10);
        }
      
        
         for(int i = 0; i < 1000; i++){
             idPicos = "";
             idPicos += linhas[i].charAt(0); 
             start = 1;
             if(linhas[i].charAt(start) != ' '){
                idPicos += linhas[i].charAt(1);
                start++;
                if(linhas[i].charAt(start) != ' '){
                idPicos += linhas[i].charAt(2);
                start++;
                }
             }
             example[i].setIdProcesso(Integer.parseInt(idPicos));
             start++;
             
             tempoChegadaPross = "";
             tempoChegadaPross += linhas[i].charAt(start);
             start++;
             while(linhas[i].charAt(start) != ' '){
                 tempoChegadaPross += linhas[i].charAt(start);
                 start++;
             }
             
             example[i].setTempoChegada(Integer.parseInt(tempoChegadaPross));
             start++;
             
             nPicos = "";
             nPicos += linhas[i].charAt(start);
             start++;

             if(linhas[i].charAt(start) != ' '){
                nPicos += linhas[i].charAt(start);
                start++;
                if(linhas[i].charAt(start) != ' '){
                nPicos += linhas[i].charAt(start);
                start++;
                }
             }

             example[i].setnPicos(Integer.parseInt(nPicos));
             pico = "";
             numPicos = example[i].getnPicos();
             indexPicos = 0;
             start++;
                for(int j = start; j < linhas[i].length() ; j++){
                    if(indexPicos < numPicos){
                        if(linhas[i].charAt(j) != ' '){
                            pico += linhas[i].charAt(j);
                        }
                        else if(linhas[i].charAt(j) == ' '){
                            picos[i].add(Integer.parseInt(pico));
                           // processos.get(i).getPicos().add(indexPicos,Integer.parseInt(pico));
                            indexPicos++;
                            pico = "";
                        }
                    }
                }
             
             
             
             example[i].setPicos(picos[i]);
             process.add(example[i]);
      }
        
        
        
    }
    
    
}
