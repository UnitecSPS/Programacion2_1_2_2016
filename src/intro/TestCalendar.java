/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Docente
 */
public class TestCalendar {
    public static void main(String[] args) {
        //1-Usemos la Calendar con la fecha actual--
        Calendar ahorita = Calendar.getInstance(); 
        //2- imprimir----
        System.out.println(ahorita.getTime());
        //3- Fecha custom-----
        Calendar ebday = Calendar.getInstance();
        ebday.set(1995, Calendar.NOVEMBER, 6);
        System.out.println("Erasmo Cumple: "+ ebday.getTime());
        //4- Como configurar una fecha con milisegundos
        Calendar mili = Calendar.getInstance();
        mili.setTimeInMillis(1);
        System.out.println("Fecha min: "+mili.getTime());
        mili.setTimeInMillis(Long.MAX_VALUE);
        System.out.println("Fecha max: "+mili.getTime());
        //5- Comparar fecha
        //      a- con milisegundos
        if(ebday.getTimeInMillis() <= ahorita.getTimeInMillis())
            System.out.println("El cumple de Erasmo fue antes que hoy");
            //  b- usando funciones de comparacion
        if(ebday.before(ahorita))
            System.out.println("Si! ya te dije que el cumple Erasmo paso antes");
        if(ahorita.after(ebday))
            System.out.println("Pues Claro si el cumple paso antes hoy fue despues");
            //c- chequear la funcion compareTo
       //6- Sacar valores individuales
            //el año
        System.out.println("Año de ahorita: "+ ahorita.get(Calendar.YEAR));
        System.out.println("Hoy en el año es el dia: "+ahorita.get(Calendar.DAY_OF_YEAR));
        int mes = ahorita.get(Calendar.MONTH);
        System.out.println("Mes de ahorita: "+mes);
        //7- Adicionar valores como años, meses o dias
        ahorita.add(Calendar.YEAR, 20);
        System.out.println("Ahorita en 20 años: "+ahorita.getTime());
        ahorita.add(Calendar.MONTH, -6);
        System.out.println("...pero 6 meses atras: "+ahorita.getTime());
        //8- Aplicacion especial
        ahorita = Calendar.getInstance();
        ahorita.add(Calendar.YEAR, -15);
        if(ebday.before(ahorita))
            System.out.println("Si el cumple de erasmo fue mas de 15 años");
        //9- Nombres
        System.out.println(ahorita.getTime());
        String month = ahorita.getDisplayName(Calendar.MONTH, 
                Calendar.LONG, 
                Locale.forLanguageTag("es"));
        System.out.println("Mes en español: "+month);
        String day = ahorita.getDisplayName(Calendar.DAY_OF_WEEK, 
                Calendar.LONG, 
                Locale.forLanguageTag("es"));
        System.out.println("Dia en español: "+day);
    }
}
