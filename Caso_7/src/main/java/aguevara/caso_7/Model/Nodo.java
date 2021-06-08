package aguevara.caso_7.Model;
import aguevara.caso_7.Model.*;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anagu
 */

//Referencias: Nuñez en Estructuras de Datos

public class Nodo <T>{

    private T TValor;
    private Nodo<T> anterior;
    private boolean visitado;
    private ArrayList<Arco<T>> listaArcos;


    public Nodo(){
        anterior = null;
        listaArcos = new ArrayList<Arco<T>>();
    }

    public Nodo(T pValue){
        anterior = null;
        TValor = pValue;
        listaArcos = new ArrayList<Arco<T>>();
    }

    public T getValor(){
        return TValor;
    }

    public void setValor(T pValue){
        TValor = pValue;
    }

    public Nodo<T> getAnterior(){
        return anterior;
    }

    public void setAnterior(Nodo<T> pAnterior){
        anterior = pAnterior;
    }

    public ArrayList<Arco<T>> getArcos(){
        return listaArcos;
    }

    public void agregarArco(Arco<T> pArco){
            listaArcos.add(pArco);
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public ArrayList<Arco<T>> getListaArcos(){
        return this.listaArcos;
    }

    @Override
    public String toString() {
        return "Nodo{" + "TValor=" + TValor + ", visitado=" + visitado + '}';
    }

}

    
    
  