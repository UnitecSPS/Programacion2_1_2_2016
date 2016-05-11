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
    
    public void aplicarCard(double monto){
        saldo += monto;
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

    @Override
    public void print() {
        System.out.print("PENDIENTE: ");
        System.out.println(this);
    }

    @Override
    public void call(int mins) {
        if(saldo > 0)
            saldo -= mins * 0.25;
        else
            System.out.println("No hay saldo. Compre Tarjeta");
    }
    
    
}
