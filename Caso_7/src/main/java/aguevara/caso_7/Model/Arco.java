package aguevara.caso_7.Model;

public class Arco <T> {

    private Nodo<T> origen;
    private Nodo<T> destino;
    private int peso;

    public Arco(Nodo<T> pOrigen, Nodo<T> pDestino, int pPeso){
        origen = pOrigen;
        destino = pDestino;
        peso = pPeso;
    }

    public Nodo<T> getOrigen(){
        return origen;
    }

    public void setOrigen(Nodo pOrigen){
        origen = pOrigen;
    }

    public Nodo<T> getDestino(){
        return destino;
    }

    public void setDestino(Nodo pDestino){
        destino = pDestino;
    }

    public int getPeso(){
        return peso;
    }

    public void setPeso(int pPeso){
        peso = pPeso;
    }

    @Override
    public String toString() {
        return "Arco{" + "origen=" + origen + ", destino=" + destino + ", peso=" + peso + '}';
    }

}

