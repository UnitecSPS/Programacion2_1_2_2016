/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.io.Closeable;
import java.io.Serializable;

/**
 *
 * @author Docente
 */
public interface Almacenable extends Serializable, Closeable {
    void savePlan(Plan p);
    Plan searchPlan(int n);
    public void list();
}
