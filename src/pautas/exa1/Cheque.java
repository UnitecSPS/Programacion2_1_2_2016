/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

/**
 *
 * @author Docente
 */
public class Cheque{
    String beneficiario;
    double monto;
    boolean rebotado;

    public Cheque(String b, 
            double m, 
            boolean r ){
            beneficiario = b;
            monto = m;
            rebotado = r;
    }	
}

