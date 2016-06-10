/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.jtunes;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class TuneTest {
    
    static JTunes jtunes = new JTunes();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        int op=0;
        
        do{
            System.out.println("\n---MENU-------");
            System.out.println("1- Agregar Cancion");
            System.out.println("2- Listar Canciones Disponibles");
            System.out.println("3- Ver Información de Cancion");
            System.out.println("4- Cambiar Precio de Cancion");
            System.out.println("5- Review una canción");
            System.out.println("6- Bajar canciones");
            System.out.println("7- Ver Factura de Download");
            System.out.println("8- Salir");
            System.out.print("Escoja opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        addSong();
                        break;
                    case 2:
                        jtunes.listSongsAvailables();
                        break;
                    case 3:
                        System.out.println("Codigo de Canción: ");
                        jtunes.viewSongInfo(lea.nextInt());
                        break;
                    case 4:
                        changePrice();
                        break;
                    case 5:
                        review();
                        break;
                }
            }
            catch(InputMismatchException e){
                lea.next();
                System.out.println("Ingrese un entero");
            }
            catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
        }while(op!=8);
        
    }

    private static void addSong()throws IOException {
        System.out.print("Nombre Cancion: ");
        String ns = lea.next();
        System.out.print("Nombre Artista: ");
        String na = lea.next();
        System.out.print("Genero: ");
        Genero gen = Genero.valueOf(lea.next().toUpperCase());
        System.out.print("Precio: ");
        double p = lea.nextDouble();
        
        jtunes.addNewSong(ns, na, gen, p);
        
    }

    private static void changePrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void review() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
