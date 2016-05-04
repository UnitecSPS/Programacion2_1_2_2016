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
    }
}
