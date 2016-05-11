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
        
        Plan plan = new Plan(1,"Jose") {
            @Override
            public double pagar() {
                return 0;
            }
            
            public void test(){
                System.out.print("Desde On Demand! Wojo! ");
            }

            @Override
            public void print() {
                test();
                System.out.println(this);
            }

            @Override
            public void call(int mins) {
                System.out.println("Sin Saldo");
            }
        };
        
        
        planes.add(plan);
        planes.add(new PlanPostPago(2,"Kevin"));
        planes.add(new PlanTarjeta(3, "Roberto"));
        
        for(Plan p : planes){
            p.print();
            System.out.println(p.pagar());
        }
    }
}
