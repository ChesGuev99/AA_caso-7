package aguevara.caso_7.program;
import aguevara.caso_7.Model.Arco;
import aguevara.caso_7.Model.Grafo;
import aguevara.caso_7.Model.Nodo;
import java.util.*;


public class cube {

    private Grafo grafo;
    private ArrayList<String> claves;


    public Grafo getGrafo() {
        return grafo;
    }


    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }


    public ArrayList<String> getClaves() {
        return claves;
    }


    public void setClaves(ArrayList<String> claves) {
        this.claves = claves;
    }


    public void cubeGraph(){
        Grafo<Integer> grafo = new Grafo<Integer>();
        ArrayList<Nodo<Integer>> inicioA = new ArrayList<Nodo<Integer>>();

        grafo.agregarNodosInt(27);

        Character[] weightsX = {'B', 'A'}; 
        Character[] weightsY = {'1', '2'}; 
        Character[] weightsZ = {'F', 'K'}; 
        int counterZ = 1;
        for (int i = 1; i < 27; i += 3) {
            Nodo<Integer> source ;
            Nodo<Integer> destinationX, destinationY, destinationZ;
            int aux = i-1;
            for (int j = 1; j <= 3; j +=1 ) {
                source = grafo.agregarNodo(j+aux);
                if(j < 3){
                    destinationX = grafo.agregarNodo(j + aux + 1);
                    char weightX = weightsX[j%2];
                    grafo.agregarArco(source, destinationX, weightX );
                    inicioA.add(source);
                    inicioA.add(destinationX);
                    //System.out.println(source.toString()+ " -> " + destinationX + "value " + weightsX[j%2]);
                }
                if(i < 19){
                    destinationY = grafo.agregarNodo(j + aux + 9);
                    grafo.agregarArco(source, destinationY, weightsY[i%2]);
                    //System.out.println(source.toString()+ " -> " + destinationY + "value " + weightsY[i/9%2]);
                }
                if((counterZ%3)!=0){
                    destinationZ = grafo.agregarNodo(j + aux + 3);
                    grafo.agregarArco(source, destinationZ, weightsZ[counterZ%2]);
                   //System.out.println(source.toString()+ " -> " + destinationZ + "value " + weightsZ[counterZ%2]);

                }


            }
            counterZ ++;
        }
        //System.out.println(grafo);
        //grafo.recorridoProfundidad(inicioA.get(0));
        setGrafo(grafo);
        getPasswords(inicioA);
    }


    public void getPasswords(ArrayList<Nodo<Integer>> inicioA){
        Grafo<Integer> grafo = this.getGrafo();
        ArrayList<String> allKeys = new ArrayList<String>();
        for (Nodo<Integer> nodo : inicioA) {
            ArrayList<String> claves = new ArrayList<String>();
            grafo.claves(nodo, "0", claves );
            //System.out.println(claves);
            allKeys.addAll(claves);
        }
        allKeys.add("01");
        this.setClaves(allKeys);
        //System.out.println(this.claves);
        //System.out.println(this.claves.size());

        
        //System.out.println();
        //grafo.recorridoProfundidad(partida);

    }

}
