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
public class PlanTarjeta extends Plan {
    
    public PlanTarjeta(int n, String c) {
        super(n, c);
    }

    @Override
    public double pagar() {
        System.out.println("Tarjeta no paga Post Pago");
        return 0;
    }

    @Override
    public String toString() {
        return "Tarjeta: "+super.toString(); 
    }
    
    
}
