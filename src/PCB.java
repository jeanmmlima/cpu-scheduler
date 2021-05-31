
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jeanmarioml
 */


public class PCB {
    
    
    private int idProcesso;
    private int estado;
    private int tempoChegada;
    private int tempoEspera;
    private int tempoFinalizacao;
    private int tempoServico;
    private int nPicos;
    private int picoAtual;
    private ArrayList<Integer> picos;
    
    public PCB(int _idProcesso, int _estado, int _nPicos){
        this.idProcesso = _idProcesso;
        this.estado = _estado;
        this.nPicos = _nPicos;
        this.picos = new ArrayList();
    }
    
    public PCB(PCB _exemplo){
        this.idProcesso = _exemplo.getIdProcesso();
        this.estado = _exemplo.getEstado();
        this.nPicos = _exemplo.getnPicos();
        this.picos = new ArrayList();
        this.picos = _exemplo.getPicos();
        this.picoAtual = _exemplo.getPicoAtual();
    }

    public long getTempoServico() {
        return tempoServico;
    }

    public void setTempoServico(int tempoServico) {
        this.tempoServico = tempoServico;
    }
    
    
    
    public long getTempoFinalizacao() {
        return tempoFinalizacao;
    }

    public void setTempoFinalizacao(int tempoFinalizacao) {
        this.tempoFinalizacao = tempoFinalizacao;
    }
    
    
    
    public long getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }
    
    
    
    public ArrayList<Integer> getPicos() {
        return picos;
    }

    public void setPicos(ArrayList<Integer> picos) {
        this.picos = picos;
    }

    public int getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(int idProcesso) {
        this.idProcesso = idProcesso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public long getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public int getnPicos() {
        return nPicos;
    }

    public void setnPicos(int nPicos) {
        this.nPicos = nPicos;
    }

    public int getPicoAtual() {
        return picoAtual;
    }

    public void setPicoAtual(int picoAtual) {
        this.picoAtual = picoAtual;
    }
    
    
    
}
