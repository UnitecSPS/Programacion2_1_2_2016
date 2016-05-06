/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.ArrayList;

/**
 *
 * @author Docente
 */
public class Claro {
    public static void main(String[] args) {
        ArrayList<Plan> planes = new ArrayList<>();
        
        planes.add(new Plan(1,"Jose"));
        planes.add(new PlanPostPago(2,"Kevin"));
        planes.add(new PlanTarjeta(3, "Roberto"));
        
        for(Plan p : planes){
            System.out.println(p);
            System.out.println(p.pagar());
        }
    }
}
