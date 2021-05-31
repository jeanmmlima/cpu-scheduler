/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.PrintWriter; 
import java.util.Scanner;

/**
 *
 * @author jeanmarioml
 */
public class LOGS {
    
    public static void alteraLinha(PCB example) throws IOException {
    String arquivo = "LOG1.txt";
    String arquivoTmp = "LOG1-tmp.txt";
    //boolean achou;

    BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
    BufferedReader reader = new BufferedReader(new FileReader(arquivo));

    String linha;
    while ((linha = reader.readLine()) != null) {
        if((linha = reader.readLine()) == null){
            writer.write("ID do Processo: "+example.getIdProcesso()+"\n");
        }
    }
   // writer.write("NOVA LINHA" + "\n");

    writer.close();        
    reader.close();

    new File(arquivo).delete();
    new File(arquivoTmp).renameTo(new File(arquivo));
    }
    
    
     public static void geraLog1(int id,int tempCheg, int tempFinaliz, int tempProcess, int tempEspera) throws IOException{
     //String mostra="\nUFRN\nSISTEMAS OPERACIONAIS\nALUNOS: Alvaro Ramos, Jean Mario, e Josiele Queiroz\n\n\n";
         String mostra="";
    String nomeArq="LOG1.txt"; //Nome do arquivo, pode ser absoluto, ou pastas /dir/teste.txt
   // String nomeArq2="ARQUIVO-temp.txt";
    String linha="";
    File arq3 = new File(nomeArq);
 
    //Arquivo existe
    if (arq3.exists()){
     // System.out.println("Arquivo - '"+nomeArq+"', aberto com sucesso!\n");
      //System.out.println("Tamanho do arquivo "+Long.toString(arq3.length())+"\n");
      //tentando ler arquivo
      try{
        //abrindo arquivo para leitura
        FileReader reader = new FileReader(nomeArq);
        
        //leitor do arquivo
        BufferedReader leitor = new BufferedReader(reader);
        while(true){
          linha=leitor.readLine();
          if(linha==null)
            break;
          mostra+=linha+"\n";
        }
        mostra += "ID DO PROCESSO: "+id+ " TEMPO DE CHEGADA: "+tempCheg+" TEMPO DE FINALIAZCAO: "+tempFinaliz+" TEMPO DE PROCESSAMENTO: "+tempProcess+" TEMPO DE ESPERA: "+tempEspera+"\n ";
        FileWriter writer = new FileWriter(nomeArq);
        PrintWriter gravarArq3 = new PrintWriter(writer);
        gravarArq3.write(mostra);
        reader.close();
        writer.close();
      }
      catch(Exception erro) {}
     // System.out.println(mostra);
    }
    //Se nao existir
    else
      System.out.println("NAO ACHO ARQUIVO");
    }
     
     public static void geraLog2(int numPronto, int numBloq, int numFinalizado) throws IOException{
     String mostra="";
    String nomeArq="LOG2.txt"; //Nome do arquivo, pode ser absoluto, ou pastas /dir/teste.txt
   // String nomeArq2="ARQUIVO-temp.txt";
    String linha="";
    File arq3 = new File(nomeArq);
 
    //Arquivo existe
    if (arq3.exists()){
     // System.out.println("Arquivo - '"+nomeArq+"', aberto com sucesso!\n");
      //System.out.println("Tamanho do arquivo "+Long.toString(arq3.length())+"\n");
      //tentando ler arquivo
      try{
        //abrindo arquivo para leitura
        FileReader reader = new FileReader(nomeArq);
        
        //leitor do arquivo
        BufferedReader leitor = new BufferedReader(reader);
        while(true){
          linha=leitor.readLine();
          if(linha==null)
            break;
          mostra+=linha+"\n";
        }
        mostra += "Prontos: "+numPronto+" Bloqueados: "+numBloq+" Finalizados: "+numFinalizado+"\n ";
        FileWriter writer = new FileWriter(nomeArq);
        PrintWriter gravarArq3 = new PrintWriter(writer);
        gravarArq3.write(mostra);
        reader.close();
        writer.close();
      }
      catch(Exception erro) {}
     // System.out.println(mostra);
    }
    //Se nao existir
    else
      System.out.println("NAO ACHO ARQUIVO");
    }
     
    public static void geraLog3(int time, int timeProcess, int timeEspera) throws IOException{
     String mostra="";
    String nomeArq="LOG3.txt"; //Nome do arquivo, pode ser absoluto, ou pastas /dir/teste.txt
   // String nomeArq2="ARQUIVO-temp.txt";
    String linha="";
    File arq3 = new File(nomeArq);
 
    //Arquivo existe
    if (arq3.exists()){
     // System.out.println("Arquivo - '"+nomeArq+"', aberto com sucesso!\n");
      //System.out.println("Tamanho do arquivo "+Long.toString(arq3.length())+"\n");
      //tentando ler arquivo
      try{
        //abrindo arquivo para leitura
        FileReader reader = new FileReader(nomeArq);
        
        //leitor do arquivo
        BufferedReader leitor = new BufferedReader(reader);
        while(true){
          linha=leitor.readLine();
          if(linha==null)
            break;
          mostra+=linha+"\n";
        }
        mostra += "Tempo medio de processamento: "+timeProcess/1000+"\n";
        mostra += "Tempo medio de espera: "+timeEspera/1000+"\n";
        mostra += "Tempo total de utilizacao da CPU: "+time+"\n";
        mostra += "Tempo que a CPU permaneceu ocupada: "+(time-117)+"\n";
        mostra += "Taxa Percentual da Ocupacao da CPU: "+((time-10)/time)+"\n";
        mostra += "Tempo que a CPU permaneceu ociosa: "+117+"\n";
        mostra += "Taxa Percentual da ociosidade da CPU: "+(117/time)+"\n";
        FileWriter writer = new FileWriter(nomeArq);
        PrintWriter gravarArq3 = new PrintWriter(writer);
        gravarArq3.write(mostra);
        reader.close();
        writer.close();
      }
      catch(Exception erro) {}
     // System.out.println(mostra);
    }
    //Se nao existir
    else
      System.out.println("NAO ACHO ARQUIVO");
    }
     
    public static void main(String[] args) throws IOException {
       
         
        //geraLogTeste(200);
        //Log2
        
        FileWriter arq2 = new FileWriter("LOG2.txt"); 
        PrintWriter gravarArq2 = new PrintWriter(arq2); 
        gravarArq2.printf("UFRN%nSISTEMAS OPERACIONAIS%nALUNOS:Alvaro Ramos, Jean Mario, e Josiele Queiroz%n%n%n"); 
        gravarArq2.printf("Número de processos na fila de pronto: %n");
        gravarArq2.printf("Número de processos na fila de bloqueados: %n");
        gravarArq2.printf("Número de processos finalizados: %n");
        arq2.close();
         System.out.printf("\nSegundo arquivo LOG gerado com sucesso!\n"); 
         
         //teste1
         
    String mostra="\nUFRN\nSISTEMAS OPERACIONAIS\nALUNOS: Alvaro Ramos, Jean Mario, e Josiele Queiroz\n\n\n";
    String nomeArq="ARQUIVO.txt"; //Nome do arquivo, pode ser absoluto, ou pastas /dir/teste.txt
   // String nomeArq2="ARQUIVO-temp.txt";
    String linha="";
    File arq3 = new File(nomeArq);
 
    //Arquivo existe
    if (arq3.exists()){
      System.out.println("Arquivo - '"+nomeArq+"', aberto com sucesso!\n");
      System.out.println("Tamanho do arquivo "+Long.toString(arq3.length())+"\n");
      //tentando ler arquivo
      try{
        //abrindo arquivo para leitura
        FileReader reader = new FileReader(nomeArq);
        
        //leitor do arquivo
        BufferedReader leitor = new BufferedReader(reader);
        while(true){
          linha=leitor.readLine();
          if(linha==null)
            break;
          mostra+=linha+"\n";
        }
        mostra += "ID DO PROCESSO: \n ";
        FileWriter writer = new FileWriter(nomeArq);
        PrintWriter gravarArq3 = new PrintWriter(writer);
        gravarArq3.write(mostra);
        reader.close();
        writer.close();
      }
      catch(Exception erro) {}
      System.out.println(mostra);
    }
    //Se nao existir
    else
      System.out.println("NAO ACHO ARQUIVO");
    }

  }
    
