/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.exarepo;

/**
 *
 * @author mac
 */
public enum TipoPrestamo {
    VIVIENDA(0.1), AUTO(0.2), PERSONAL(0.3);
    public double tasa;
    
    private TipoPrestamo(double t){
        tasa = t;
    }
}
