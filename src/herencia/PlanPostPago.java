/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.Calendar;

/**
 *
 * @author Docente
 */
public class PlanPostPago extends Plan {
    protected Calendar corte;
    
    public PlanPostPago(int n, String c){
        super(n,c);
        saldo = 5;
        corte = Calendar.getInstance();
    }

    public Calendar getCorte() {
        return corte;
    }
    
    @Override
    public double pagar(){
        System.out.println("Saldo al "+
                corte.getTime()+": "+saldo);
        return saldo;
    }
    
    @Override
    public String toString(){
        return "PostPago: "+super.toString()+" Corte: "+corte.getTime();
    }
}
