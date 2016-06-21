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
public class Nodo {
    public String nombre;
    public Nodo siguiente;

    public Nodo(String nombre) {
        this.nombre = nombre;
        siguiente = null;
    }

    @Override
    public String toString() {
        return "Nodo{" + "nombre=" + nombre + '}';
    }
    
    
}
