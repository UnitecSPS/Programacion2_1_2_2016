/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.jtunes;

/**
 *
 * @author Docente
 */
public class DownloadItem {
    public String nc,na;
    public double price;

    public DownloadItem(String nc, String na, double price) {
        this.nc = nc;
        this.na = na;
        this.price = price;
    }

    @Override
    public String toString() {
        return nc + " by " + na + " $" + price;
    }
    
    
}
