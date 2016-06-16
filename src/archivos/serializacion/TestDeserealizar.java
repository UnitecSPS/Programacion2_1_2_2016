/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.serializacion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Docente
 */
public class TestDeserealizar {
    public static void main(String[] args) {
        try{
            //1-Crear un FileInputStream
            FileInputStream file = new FileInputStream("frances.cbc");
            //2-Crear un ObjectInputStream
            ObjectInputStream data = new ObjectInputStream(file);
            //3-leemos
            CuentaBancaria cb = (CuentaBancaria)data.readObject();
            System.out.println("Se deserealizo: ");
            System.out.println(cb);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
