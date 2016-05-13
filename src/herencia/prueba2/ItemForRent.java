/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.prueba2;

/**
 *
 * @author Docente
 */
public abstract class ItemForRent {
    protected int id;
    public static final int VERSION=1;
    
    public ItemForRent(int i){
        id = i;
    }
    
    public void print(){
        System.out.println(id);
    }
    
    public abstract double rent(int dias);
}
