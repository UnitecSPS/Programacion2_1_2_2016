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
    public static final int MIN_INTERNET=15;
    
    public PlanSmartPhone(int n, String c) {
        super(n, c);
        planInternet = MIN_INTERNET;
    }

    public void setPlanInternet(double pi) {
        if(pi > MIN_INTERNET)
            planInternet = pi;
    }

    @Override
    public double pagar() {
        return super.pagar()+planInternet; 
    }
    
    public String toString(){
        return "SmartPhone: "+super.toString()+" Internet: "+planInternet;
    }
    
}
