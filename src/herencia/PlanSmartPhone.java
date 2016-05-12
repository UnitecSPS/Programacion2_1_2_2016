/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Docente
 */
public final class PlanSmartPhone extends PlanPostPago {
    public double planInternet;
    
    public PlanSmartPhone(int n, String c, double i) {
        super(n, c);
        planInternet = i;
    }

    public void setPlanInternet(double planInternet) {
        this.planInternet = planInternet;
    }

    @Override
    public double pagar() {
        return super.pagar()+planInternet; 
    }
    
    
    
}
