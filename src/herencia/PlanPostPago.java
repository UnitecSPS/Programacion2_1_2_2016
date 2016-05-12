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
        //tengo 1 mes
        corte = Calendar.getInstance();
        corte.add(Calendar.MONTH,1);
    }
    

    public Calendar getCorte() {
        return corte;
    }
    
    @Override
    public double pagar(){
        double pago = saldo;
        Calendar hoy = Calendar.getInstance();
        if(hoy.after(corte))
            pago += 5;
        
        System.out.println("Saldo al "+
                corte.getTime()+": "+pago);
        reset();
        return pago;
    }
    
    @Override
    public String toString(){
        return "PostPago: "+super.toString()+" Corte: "+corte.getTime();
    }

    @Override
    public void print() {
        System.out.println(this);
    }
    
    public void reset(){
        corte.add(Calendar.MONTH, 1);
        saldo = 0;
    }

    @Override
    public void call(int mins) {   
        saldo += mins * 0.5;
    }
}
