/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import errores.TarjetaInvalidaException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
MENU:
    LA COLECCION QUE SEA UN ARRAYLIST
    1- Agregar un plan (de los 3 tipos:
        Postpago, Tarjet a o SmartPhone)
        validar: que el numero sea unico
    2- Llamar utilizando plan segun un numero
    3- Imprimir la informacion de un plan segun un numero
    4- Listar todos los planes
    5- Aplicar Tarjeta (SOLO A LOS DE TARJETA) por
        lo que validar que el numero de plan sea de tarjeta
    6- Cambiar plan de internet (SOLO A LOS PLANSMARTPHONE)
    7- Pagar una cuenta de un plan
*/
public class JavaCell {
    private static Almacenable manager = new PlanList();
    private static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {

        //Plan.VERSION = 2;
        System.out.println(Plan.VERSION);
        
        int op=0;
        
        do{
            System.out.println("\nMENU\n------------");
            System.out.println("1- Agregar Plan");
            System.out.println("2- Llamar desde un Plan");
            System.out.println("3- Imprimir un plan");
            System.out.println("4- Listar Planes");
            System.out.println("5- Aplicar Tarjeta");
            System.out.println("6- Cambiar Plan Internet");
            System.out.println("8- Salir");
            System.out.print("Escoja opcion: ");
            
            try{
                op = lea.nextInt();

                switch(op){
                    case 1:
                        addPlan();
                        break;
                    case 2:
                        call();
                        break;
                    case 3:
                        System.out.println("TODO");
                        break;
                    case 4:
                        list();
                        break;
                    case 5:
                        applyCard();
                        break;
                    case 6:
                        setInternet();
                }
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingrese un entero");
                lea.next();
            }
            catch(TarjetaInvalidaException e){
                System.out.println(e.getMessage());
                System.out.println("Por favor ingrese una tarjeta valida");
            }
            catch(IllegalArgumentException e){
                System.out.println("Plan Incorrecto");
            }
        }while(op!=8);
    }

    private static void addPlan() {
        System.out.println("Numero: ");
        int num = lea.nextInt();
        System.out.println("Nombre: ");
        String c = lea.next();
        System.out.println("TIPOS DISPONIBLES:\n--------");
        for(TipoPlan t : TipoPlan.values())
            System.out.println("-"+t);
        System.out.println("Tipo: ");
        TipoPlan t = TipoPlan.valueOf(lea.next().toUpperCase());
        
        if(manager.searchPlan(num) == null){
            switch(t){
                case POSTPAGO:
                    manager.savePlan(new PlanPostPago(num, c));
                    break;
                case TARJETA:
                    manager.savePlan(new PlanTarjeta(num, c));
                    break;
                case SMART:
                    manager.savePlan(new PlanSmartPhone(num, c));
                    break;
          
            }
        }
        else
            System.out.println("Lo siento, Numero ya tomado");
    }

    private static void call() {
        System.out.println("Numero origen: ");
        int no = lea.nextInt();
        System.out.println("Cantidad minutos: ");
        int mins = lea.nextInt();
        
        Plan p = manager.searchPlan(no);
        
        if(p != null ){
            p.call(mins);
        } 
        else
            System.out.println("Numero Equivocado");
    }

    private static void list() {
        manager.list();
    }

    private static void applyCard() {
       System.out.println("Numero origen: ");
       int no = lea.nextInt();
       System.out.println("Monto: ");
       double m = lea.nextDouble();
       
       Plan p = manager.searchPlan(no);
       
       if(p instanceof PlanTarjeta){
           ((PlanTarjeta)p).aplicarCard(m);
       }
       else
            System.out.println("No se encuentra ese plan de tarjeta");
    }

    private static void setInternet() {
       
       System.out.println("Numero origen: ");
       int no = lea.nextInt();
       System.out.println("Plan Internet: ");
       TipoInternet ti = TipoInternet.valueOf(lea.next().toUpperCase());
       
       Plan p = manager.searchPlan(no);
       
       if(p instanceof PlanSmartPhone)
           ((PlanSmartPhone)p).setPlanInternet(ti);
       else
            System.out.println("No se encontro o no es smart plan");
    }
}
