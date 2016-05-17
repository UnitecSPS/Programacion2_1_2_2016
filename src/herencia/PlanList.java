/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Docente
 */
public class PlanList implements Almacenable {
    
    ArrayList<Plan> planes;
    
    public PlanList(){
        planes = new ArrayList<>();
    }
        
     @Override
    public void savePlan(Plan p) {
        planes.add(p);
    }

    @Override
    public Plan searchPlan(int n) {
        for(Plan p : planes){
            if(p.getNumero() == n)
                return p;
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void list() {
        for(Plan p : planes){
            p.print();
        }
    }


    
}
