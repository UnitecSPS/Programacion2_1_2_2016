/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.serializacion;

import java.io.Serializable;

/**
 *
 * @author Docente
 */
public class CuentaBancaria implements Serializable{
    public String cliente;
    public int numero;
    public double saldo;
    public transient TipoCuenta tipo;
    

    public CuentaBancaria(int numero, String cliente) {
        this.cliente = cliente;
        this.numero = numero;
        saldo = 500;
    }

    public void setTipo(TipoCuenta tipo) {
        this.tipo = tipo;
    }
    
    public void depositar(double m){
        saldo += m;
    }
    
    public void retirar(double m){
        if(saldo >= m)
            saldo -= m;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + "cliente=" + cliente + ", numero=" + 
                numero + ", saldo=" + saldo + tipo+'}';
    }
    
    
}
