/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class TestEnum {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        
        System.out.println("Todos los TipoPlan:");
        for(TipoPlan t : TipoPlan.values())
            System.out.println("-"+t);
        
        TipoPlan tp = TipoPlan.SMART;
        
        if(tp == TipoPlan.SMART){
            System.out.println("SI ES SMART!");
        }
        
        System.out.println("Es: "+ tp);
        
        System.out.print("Ingresa ahora el tipo: ");
        tp = TipoPlan.valueOf(lea.next().toUpperCase());
        System.out.println("Ingrese un: "+tp.name());
        System.out.println("Y el ordina es: "+tp.ordinal());
        
        TipoInternet ti = TipoInternet.PREMIUM;
        System.out.println("Es: "+ti+" con monto: "+ti.monto);
        
        //COn la clase
        System.out.println("\nTodos los TipoPlanClass:");
        for(TipoPlanClass tc : TipoPlanClass.values())
            System.out.println("-"+tc);
        
        TipoPlanClass tpc = TipoPlanClass.SMART;
        if(tpc == TipoPlanClass.SMART){
            System.out.println("SI ES SMART!");
        }
        System.out.println("Es: "+tpc);
        
        System.out.print("Ingresa ahora el tipo: ");
        tpc = TipoPlanClass.valueOf(lea.next().toUpperCase());
        System.out.println("Ingrese un: "+tpc.name());
        System.out.println("Y el ordinal es: "+tpc.ordinal());
    }   
        
}
