/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author Docente
 */
public class TestRec {
    public static void main(String[] args) {
        RecursionLibrary rl = new RecursionLibrary();
        
        rl.printRec(5);
        System.out.println("Ahora el otro  \n---");
        rl.printRec2(1, 6);
    }
}
