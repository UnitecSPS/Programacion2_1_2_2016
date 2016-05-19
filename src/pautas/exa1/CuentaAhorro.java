/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

import java.util.Calendar;

/**
 *
 * @author Docente
 */
public final class CuentaAhorro extends CuentaBancaria implements Desactivable {
    private Calendar fecha;
    private boolean activo;
    
    public CuentaAhorro(int n, String no){
        super(n,no);
        fecha = Calendar.getInstance();
        activo = true;
    }
    
    @Override
    public void deposito(double m){
        if(!activo){
            saldo += m*0.9;
            activo = true;
        }
        else
            saldo += m;
        fecha = Calendar.getInstance();
    }
    
    @Override
    boolean retiro(double m) {
        if(activo && saldo >= m ){
            saldo -= m;
            fecha = Calendar.getInstance();
            return true;
        }
        return false;
    }

    @Override
    public void desactivar() {
        Calendar hace6 = Calendar.getInstance();
        hace6.add(Calendar.MONTH, -6);
        if(fecha.before(hace6))
            activo = false;
    }
    
    @Override
    public String toString(){
        return super.toString()+"Ahorro"+
                (activo ? "Activa" : "Desactivada");
    }
}
