/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.prueba2;

import java.util.Calendar;

/**
 *
 * @author Docente
 */
public class MovieForRent extends ItemForRent {
    private String title;
    private Calendar release;
    
    public MovieForRent(int i, String t){
        super(i);
        title = t;
        release = Calendar.getInstance();
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println(title+release);
    }
    
    @Override
    public double rent(int dias){
        Calendar hace3meses = Calendar.getInstance();
        hace3meses.add(Calendar.MONTH, -3);
        
        if(release.before(hace3meses))
            return 15*dias;
        return 20 * dias;
    }
    
    /// III
    public static void main(String[] args) {
        ItemForRent ifr = new MovieForRent(1,"Avatar");
    }
}
