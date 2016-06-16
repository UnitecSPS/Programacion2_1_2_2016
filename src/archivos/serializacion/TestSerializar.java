/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.serializacion;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Docente
 */
public class TestSerializar {
    public static void main(String[] args) {
        CuentaBancaria cb = new CuentaBancaria(1,"Frances");
        cb.depositar(1000);
        cb.retirar(300);
        cb.setTipo(new TipoCuenta("VIP", 0.15));
        System.out.println(cb);
        
        try{
            //1-Crear un objeto FileOutputStream
            FileOutputStream file = new FileOutputStream("frances.cbc");
            //2- Crear un objeto DataOutputStream
            ObjectOutputStream data = new ObjectOutputStream(file);
            //3-escribimos
            data.writeObject(cb);
            //4-cerrar
            data.close();
            file.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
