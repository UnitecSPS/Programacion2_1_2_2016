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
    public TipoInternet planInternet;
    public static final int MIN_INTERNET=15;
    
    public PlanSmartPhone(int n, String c) {
        super(n, c);
        planInternet = TipoInternet.NORMAL;
    }

    public void setPlanInternet(TipoInternet pi) {
        planInternet = pi;
    }

    @Override
    public double pagar() {
        return super.pagar()+planInternet.monto; 
    }
    
    public String toString(){
        return "SmartPhone: "+super.toString()+" Internet: "+planInternet+"Lp."+
                planInternet.monto;
    }
    
}
