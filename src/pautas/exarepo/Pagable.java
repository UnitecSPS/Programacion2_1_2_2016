/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.exarepo;

import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author mac
 */
public interface Pagable extends Serializable{
    boolean pay()throws IOException;
    double balance()throws IOException;
}
