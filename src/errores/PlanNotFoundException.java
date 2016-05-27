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
public class PlanNotFoundException extends RuntimeException {
    
    public PlanNotFoundException(int num){
        super("Plan con el numero "+num+" no existe");
    }
}
