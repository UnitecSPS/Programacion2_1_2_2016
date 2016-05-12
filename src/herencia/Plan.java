/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.Calendar;

/**
 *
 * @author Docente
 */
public abstract class Plan {
    public static final int VERSION = 1;
    protected int numero;
    protected String cliente, celular;
    protected Calendar ultimoUso;
    protected double saldo;
    
    public Plan(int n, String c){
        numero = n;
        cliente = c;
        celular = "";
        ultimoUso = Calendar.getInstance();
        saldo = 0;
    }

    public final int getNumero() {
        return numero;
    }

    public final String getCliente() {
        return cliente;
    }

    public String getCelular() {
        return celular;
    }

    public Calendar getUltimoUso() {
        return ultimoUso;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public abstract double pagar();
    public abstract void print();
    public abstract void call(int mins);

    @Override
    public String toString() {
        return "{" + "numero=" + numero + ", cliente=" + cliente + ", celular=" + celular + ", saldo=" + saldo + '}';
    }
    
    
}
