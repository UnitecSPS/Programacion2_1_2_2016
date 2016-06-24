/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.exarepo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;

/**
 *
 * @author mac
 */
public class Prestamo implements Pagable{
    private int numero, cuotas;
    private double monto, intereses;
    private String cliente;
    private transient RandomAccessFile rcuotas;
    private TipoPrestamo tipo;
    
    public Prestamo(int nu, String cli, double mo, int cc, TipoPrestamo ti){
        if(mo <= 500)
            throw new BadAmountException(mo);
        numero = nu;
        cliente = cli;
        monto = mo;
        cuotas = cc;
        tipo = ti;
        
        intereses = monto * tipo.tasa;
        initCuotasFile();
    }
    
    private void initCuotasFile(){
        try{
            rcuotas = new RandomAccessFile("cuotas_"+numero+".pre", "rw");
            double cuota = (monto+intereses)/cuotas;
            Calendar cal = Calendar.getInstance();
            
            for(int c=1; c<=cuotas; c++){
                cal.add(Calendar.MONTH, 1);
                rcuotas.writeLong(cal.getTimeInMillis());
                rcuotas.writeDouble(cuota);
                rcuotas.writeBoolean(false);
            }
            
        }catch(IOException e){
            
        }
    }

    @Override
    public boolean pay() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double balance() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
