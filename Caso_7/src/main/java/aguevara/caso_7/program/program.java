/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aguevara.caso_7.program;
import aguevara.caso_7.Model.Arco;
import aguevara.caso_7.Model.Grafo;
import aguevara.caso_7.Model.Nodo;
import aguevara.caso_7.logic.probabilista;
import aguevara.caso_7.program.cube;
import aguevara.caso_7.utils.*;

import java.util.*;



/**
 *
 * @author anagu
 */
public class program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        cube cubo = new cube();
        cubo.cubeGraph();
        utils u = new utils();
        u.orderList(cubo.getClaves());
        //System.out.println(u.getOrderedList());
        System.out.println(u.getTotal());
        probabilista prob = new probabilista();
        prob.tableUpdate(u);
        
    }
    
}
