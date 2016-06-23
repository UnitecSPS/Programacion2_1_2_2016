/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.exarepo;

import java.io.RandomAccessFile;

/**
 *
 * @author mac
 */
public class Prestamo {
    private int numero, cuotas;
    private double monto, intereses;
    private String cliente;
    private transient RandomAccessFile rcuotas;
    
    public Prestamo(){
        
    }
    
    private void initCuotasFile(){
        
    }
}
