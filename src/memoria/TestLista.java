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
public class TestLista {
    public static void main(String[] args) {
        Lista list = new Lista();
        
        list.add( new Nodo("Erasmo") );
        list.add( new Nodo("Owen") );
        list.add( new Nodo("Leo") );
        list.add( new Nodo("Renan") );
        
        list.print();
        
    }
}
