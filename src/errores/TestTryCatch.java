/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class TestTryCatch {
    public static void main(String[] args) {
        System.out.println("Iniciando Main");
        //int x = 5/0;
        try{
            System.out.println("Iniciando Try");
            a();
            System.out.println("Finalizando Try");
        }
        catch(InputMismatchException e){
            System.out.println("Por favor ingrese un entero");
            //throw e;
        }
        catch(NumberFormatException e){
            System.out.println("Valor no es entero");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Por favor ingrese una posicion valida");
        }
        catch(ArithmeticException e){
            System.out.println("Lo siento, no podes dividir entre cero");
        }
        catch(Exception e){
            System.out.println("Error: "+e);
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
            
        System.out.println("Finalizando Main");
    }

    private static void a() {
        System.out.println("Inciando a()");
        b();
        System.out.println("Finalizando a()");
    }

    private static void b() {
        System.out.println("Inciando b()");
        //------
        String numeros[] = { "0","1","hola", null };
        Scanner lea = new Scanner(System.in);
        int pos = lea.nextInt();
        System.out.println("Lenght de Cadena: "+
                numeros[pos].length());
        int x = Integer.parseInt(numeros[pos]);
        System.out.println("10/"+x+": "+(10/x));
        //-----
        System.out.println("Finalizando b()");
    }

    private static void cerrarConexion() {
        System.out.println("Cerrando conexion.....");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
