package aguevara.caso_7.utils;
import aguevara.caso_7.Model.Arco;
import aguevara.caso_7.Model.Grafo;
import aguevara.caso_7.Model.Nodo;
import aguevara.caso_7.program.cube;
import java.util.*;

public class utils {

    public ArrayList<ArrayList<String>> orderedList;
    public int total;

    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<ArrayList<String>> getOrderedList() {
        return orderedList;
    }

    public void setOrderedList(ArrayList<ArrayList<String>> orderedList) {
        this.orderedList = orderedList;
    }

    public int compartSize(int i, int j){
        return (Integer)compartSize(i, j);
    }
    
    public void orderList(ArrayList<String> claves){
        ArrayList<ArrayList<String>> orderedList = new ArrayList<ArrayList<String>>();
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            orderedList.add(new ArrayList<String>());
        }
        for (String key : claves) {
            key = key.replace("0", "");
            if(!orderedList.get(key.length()-1).contains(key)){
                orderedList.get(key.length()-1).add(key);
                counter++;
            }
        }
        for (int i = 0; i < 6; i++) {
            Collections.sort(orderedList.get(i));
        }
        setTotal(counter);
        setOrderedList(orderedList);
        System.out.println(counter);
        System.out.println(orderedList.size());
    }



}
