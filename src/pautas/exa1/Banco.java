/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

import java.util.ArrayList;

/**
 *
 * @author Docente
 */
public class Banco {
    ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
    
    public CuentaBancaria search(int n){
        for(CuentaBancaria cb : cuentas){
            if(cb.getNumero() == n)
                return cb;
        }
        return null;
    }
    
    public void addCuenta(int num, String cli, String tipo){
        if(search(num) == null){
            if(tipo.equals("AHORRO"))
                cuentas.add(new CuentaAhorro(num,cli));
            else if(tipo.equals("CHEQUE"))
                cuentas.add(new CuentaCheque(num,cli));
        }
    }
    
    public boolean transferir(int n1, int n2, double m){
        CuentaBancaria c1 = search(n1);
        CuentaBancaria c2 = search(n2);
        
        if(c1 != null && c2 != null){
            if(c1.retiro(m)){
                c2.deposito(m);
                return true;
            }
        }
        return false;
    }
    
    public void evaluarDesactivados(){
        evaluarDesactivados(0);
    }

    private void evaluarDesactivados(int pos) {
        if(pos < cuentas.size()){
            CuentaBancaria cuenta = cuentas.get(pos); 
            if(cuenta instanceof CuentaAhorro)
                ((CuentaAhorro)cuenta).desactivar();
            evaluarDesactivados(pos+1);
        }
    }
    
    public void printInfo(int nc){
        CuentaBancaria cuenta = search(nc);
        if(cuenta != null){
            System.out.println(cuenta);
            if(cuenta instanceof CuentaCheque)
                ((CuentaCheque)cuenta).listarCheques();
        }
    }
}
