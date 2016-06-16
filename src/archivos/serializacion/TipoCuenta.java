/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.serializacion;

import com.sun.jndi.toolkit.dir.SearchFilter;
import java.io.Serializable;

/**
 *
 * @author Docente
 */
public class TipoCuenta implements Serializable{
    public String nombre;
    public double tasa;

    public TipoCuenta(String nombre, double tasa) {
        this.nombre = nombre;
        this.tasa = tasa;
    }

    @Override
    public String toString() {
        return " TipoCuenta{" + "nombre=" + nombre + ", tasa=" + tasa + '}';
    }
    
    
}
