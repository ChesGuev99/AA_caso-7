package aguevara.caso_7.logic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import aguevara.caso_7.program.*;
import aguevara.caso_7.utils.utils;

public class probabilista {
    private Map<Integer, Double> distribution;
    private double distSum;
    public int lastRand;


    public int getLastRand() {
        return lastRand;
    }


    public void setLastRand(int lastRand) {
        this.lastRand = lastRand;
    }


    public probabilista() {
        distribution = new HashMap<>();
    }


    public void addNumber(int value, double distribution) {
        if (this.distribution.get(value) != null) {
            distSum -= this.distribution.get(value);
        }
        this.distribution.put(value, distribution);
        distSum += distribution;
    }

    public void tableUpdate(utils u){

        for (int i = 0; i < u.getOrderedList().size(); i++) {
            //System.out.println(u.getTotal());
            //System.out.println(u.getOrderedList().get(i).size()); 
            //System.out.println((double) u.getOrderedList().get(i).size() / (double)50);
            double percentage  =  (double) u.getOrderedList().get(i).size() / (double)u.getTotal();
            addNumber(i, percentage);
            //distribution.put(i,percentage);
        }
        System.out.println(distribution);

    }

    public int getRandom(utils u) {
        double rand = Math.random();
        double ratio = 1.0f / distSum;
        double tempDist = 0;
        for (Integer i : distribution.keySet()) {
            tempDist += distribution.get(i);
            if (rand / ratio <= tempDist) {
                return i;
            }
        }
        return 0;
    }

    public String probability(utils u){
        int random = getRandom(u); 
        setLastRand(lastRand);
        System.out.println(random);
        if(u.getOrderedList().get(random).size()!=0){
            String clave = u.getOrderedList().get(random).get(0);
            System.out.println(clave);
            u.deleteClave(u.getOrderedList().get(random));
            return clave;
        }
        return "";

    }    


}
