/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

/**
 *
 * @author Docente
 */
public class Lista {
    public Nodo raiz = null;
    
    public void add(Nodo obj){
        if( raiz == null ){
            raiz = obj;
        }
        else{
            Nodo tmp = raiz;
            
            while(tmp.siguiente != null){
                tmp = tmp.siguiente;
            }
            
            tmp.siguiente = obj;
        }
    }
    
}
