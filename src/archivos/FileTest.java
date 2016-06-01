/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class FileTest {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        String path = lea.nextLine();
        
        File fi = new File(path);
        
        if(fi.exists())
            System.out.println("Si existe");
        else
            System.out.println("No Existe");
    }
}
