package aguevara.caso_7.logic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import aguevara.caso_7.program.*;
import aguevara.caso_7.utils.utils;

public class probabilista {
    private Map<Integer, Double> distribution;
    private double distSum;

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

    public void probability(){


    }    


}
