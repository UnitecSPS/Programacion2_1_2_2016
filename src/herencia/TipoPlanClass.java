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
public class TipoPlanClass {
    public static final TipoPlanClass POSTPAGO=new TipoPlanClass("POSTPAGO",0);
    public static final TipoPlanClass SMART=new TipoPlanClass("SMART",1);
    public static final TipoPlanClass TARJETA=new TipoPlanClass("TARJETA",2);

    private String name;
    private int ordinal;
    
    public TipoPlanClass(String n, int o){
        name = n;
        ordinal = o;
    }

    @Override
    public String toString() {
        return name();
    }
    
    public String name(){
        return name;
    }
    
    public int ordinal(){
        return ordinal;
    }
    
    public static TipoPlanClass valueOf(String e){
        switch(e){
            case "POSTPAGO":
                return POSTPAGO;
            case "SMART":
                return SMART;
            case "TARJETA":
                return TARJETA;
            default:
                throw new IllegalArgumentException(e+" is not an element");
        }
    }
    
    public static TipoPlanClass[] values(){
        TipoPlanClass arr[] = {POSTPAGO, SMART, TARJETA};
        return arr;
    }
}
