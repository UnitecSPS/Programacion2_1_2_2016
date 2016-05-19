/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public final class CuentaCheque extends CuentaBancaria {

    ArrayList<Cheque> cheques;
    
    public CuentaCheque(int n, String no){
        super(n,no);
        cheques = new ArrayList<>();
    }
    
    @Override
    boolean retiro(double m) {
        Scanner lea = new Scanner(System.in);
        String b = lea.next();
        boolean rebot = saldo < m;
        if(!rebot)
            saldo -= m;
        cheques.add(new Cheque(b,m,rebot));
        return !rebot;
    }
    
    public void listarCheques(){
        int p=0;
        for(Cheque ch : cheques){
            System.out.println(p+ch.beneficiario+
                    ch.monto+ch.rebotado);
            p++;
        }
    }
    
    @Override
    public String toString(){
        return super.toString()+"Cheque";
    }
}
