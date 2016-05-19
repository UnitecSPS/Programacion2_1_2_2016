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
public abstract class CuentaBancaria {
    protected int numero;
    protected String nombre;
    protected double saldo;

    public CuentaBancaria(int numero,String nombre) {
        this.numero = numero;
        this.nombre = nombre;
        saldo = 500;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void deposito(double m){
        saldo += m;
    }
    
    abstract boolean retiro(double m);

    @Override
    public String toString() {
        return numero + nombre + saldo ;
    }
    
    
}
