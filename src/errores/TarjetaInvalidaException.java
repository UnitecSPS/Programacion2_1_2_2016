/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

/**
 *
 * @author Docente
 */
public class TarjetaInvalidaException extends RuntimeException {
    
    public TarjetaInvalidaException(double m){
        super("Monto "+m+" invalido para Tarjeta");
    }
}
