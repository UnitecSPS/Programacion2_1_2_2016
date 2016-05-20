/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Docente
 */
public enum TipoInternet {
    NORMAL(10.99), PREMIUM(22.99), EXTREME(50.99), VIP(80.99);
    public double monto;
    
    TipoInternet(double m){
        monto = m;
    }
}
