/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Docente
 */
public class Tigo {
    public static void main(String[] args) {
        PlanPostPago ppp = new PlanPostPago(995,"Jose");
        ppp.cliente = "Erasmo";
        System.out.println(ppp.cliente);
        
        if(ppp instanceof PlanPostPago)
            System.out.println("Si soy Post Pago");
        if(ppp instanceof Plan)
            System.out.println("Si soy plan tambien");
        if(ppp instanceof Object)
            System.out.println("Si soy un Object");
        
        //upcasting
        Plan p = new PlanPostPago(998, "Bryan");
        if(p instanceof PlanPostPago){
            System.out.println("Sii jaja soy PostPago");
            PlanPostPago post = (PlanPostPago)p;
            System.out.println(post.getCorte());
            post.cliente = "Gino";
        }
        System.out.println(p);
        System.out.println(((PlanPostPago)p).getCorte());
       
    }
}
