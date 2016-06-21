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
public class Base {
    public static void main(String[] args) {
        Nodo a = new Nodo("Carlos");
        Nodo b = a;
        
        b.nombre = "Marlon";
        
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        
        if( a == b )
            System.out.println("Los dos estan en el mismo espacio");
        
        String c1 = "hola";
        String c2 = "hola";
        
        if( c1 == c2 )
            System.out.println("Las dos cadenas son iguales");
    }
}
