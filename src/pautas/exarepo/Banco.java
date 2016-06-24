/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.exarepo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class Banco {
    private ArrayList<Prestamo> cuentas = new ArrayList<>();
    
    void addPrestamo(String cli, double mon, int cuotas, String tipo){
        try{
            int n = cuentas.size()+1;
            cuentas.add(new Prestamo(n, cli, mon, cuotas, TipoPrestamo.valueOf(tipo)));
        }
        catch(IllegalArgumentException e){
            
        }
    }
    
    void backup()throws IOException{
        FileOutputStream fo = new FileOutputStream("prestamos.pre");
        ObjectOutputStream os = new ObjectOutputStream(fo);
        os.writeObject(cuentas);
        os.close();
        fo.close();
    }
    
    double montoAdeudado()throws IOException{
        return montoAdeudado(0);
    }

    private double montoAdeudado(int pos)throws IOException {
        if(pos < cuentas.size()){
            return cuentas.get(pos).balance() + 
                    montoAdeudado(pos+1);
        }
        return 0;
    }
}
