package aguevara.caso_7.Model;
import aguevara.caso_7.Model.Arco;
import aguevara.caso_7.Model.Nodo;
import java.util.ArrayList;

public class Grafo <T>{
    
    private ArrayList<Nodo<T>> listaNodos;
    private ArrayList<Arco<T>> listaArcos;
    
    public Grafo() {
        listaNodos = new ArrayList<Nodo<T>>();
        listaArcos = new ArrayList<Arco<T>>();
    }
    
    public Nodo<T> agregarNodo(T pValue){       
        Nodo<T> nuevoNodo = getNodo(pValue);
        if (nuevoNodo == null){
            new Nodo(pValue);
            listaNodos.add(nuevoNodo);
        }
        return nuevoNodo;
    }
    
    public void agregarArco(Nodo<T> origen, Nodo<T> destino, int peso){
        Arco<T> nuevoArco = new Arco(origen, destino, peso);
        listaArcos.add(nuevoArco);     
        origen.agregarArco(nuevoArco);
        
        nuevoArco = new Arco(destino, origen, peso);
        listaArcos.add(nuevoArco);        
        destino.agregarArco(nuevoArco);        
    }
    
    public void agregarNodosInt(int cantidad){
        for (int i = 1; i <= cantidad; i++) {
            Nodo<T> nuevoNodo = new Nodo(i);
            listaNodos.add(nuevoNodo);        }
    }
    
    
    public ArrayList<Nodo<T>> getNodos(){
        return listaNodos;
    }

    public Nodo<T> getNodo(T Value){
        for (Nodo<T> nodo : listaNodos) {
            if(nodo.getValor() == Value){
                return nodo;
            }
        }
        return null;
    }

    public ArrayList<Nodo<T>> getNodosOf(T value){
        Nodo<T> nodo = getNodo(value);
        ArrayList<Nodo<T>> nodos = new ArrayList<Nodo<T>>();
        if(nodo!=null){
            for (Arco<T> arco : nodo.getArcos() ) {
                nodos.add(arco.getDestino());
            }
            return nodos;
        }
        else{
            System.out.println("nope");
            return null;
        }
        

    }

    @Override
    public String toString() {
        return "Grafo{" + "listaNodos=" + listaNodos + ", listaArcos=" + listaArcos + '}';
    }
    
    public void recorridoAnchura(Nodo<T> pPartida){
        System.out.println("\n**********************************************\nRecorrido en Anchura:");
        ArrayList<Nodo<T>> cola = new ArrayList<Nodo<T>>();
        cola.add(pPartida);
        Nodo<T> cabeza = null;
        while(!cola.isEmpty()){
            cabeza = cola.get(0);
            cola.remove(0);
            cabeza.setVisitado(true);
            System.out.println("Nodo:" + cabeza);
            for(Arco<T> i : cabeza.getListaArcos()){
                if(!i.getDestino().isVisitado()){
                    cola.add(i.getDestino());
                    i.getDestino().setVisitado(true);
                }
            }
        }
    }

    
    public void recorridoProfundidad(Nodo<T> pPartida){
        System.out.println("\n**********************************************\nRecorrido en Profundidad:");
        ArrayList<Nodo<T>> pila = new ArrayList<Nodo<T>>();
        pila.add(pPartida);
        Nodo<T> cabeza = null;
        while(!pila.isEmpty()){
            cabeza = pila.get(0);
            pila.remove(0);
            cabeza.setVisitado(true);
            System.out.println("Nodo:" + cabeza);
            for(Arco<T> i : cabeza.getListaArcos()){
                if(!i.getDestino().isVisitado()){
                    pila.add(0, i.getDestino());
                    i.getDestino().setVisitado(true);
                }
            }
        }
    }
    

    public ArrayList<String> claves(Nodo<Integer> pPartida, String clave, ArrayList<String> listaClaves){
        ArrayList<Arco<Integer>> lista =  pPartida.getListaArcos();
        pPartida.setVisitado(true);
        //System.out.println(lista);
        for (Arco<Integer> arco : lista) {
            Nodo<Integer> siguiente = arco.getDestino();
            //System.out.println(siguiente.getListaArcos());

            //System.out.println("actual "+ pPartida + "-> siguiente" + siguiente + "peso " + arco.getPeso());
            if((arco.getPeso() > clave.charAt(clave.length()-1)) && (!siguiente.isVisitado())){
                claves(siguiente, clave+= (char)arco.getPeso(), listaClaves);
            }
            else{
                //System.out.println(clave);
                if(!listaClaves.contains(clave)){
                    listaClaves.add(clave);
                }
            }
            pPartida.setVisitado(false);
        }
        return listaClaves;
    }
}