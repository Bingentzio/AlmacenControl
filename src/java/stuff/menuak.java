/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stuff;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author bingen
 */
@ManagedBean
@SessionScoped
public class menuak implements java.io.Serializable {
    
    /**
     * Creates a new instance of ProductoBean
     */

    
    private int myActiveIndex;

    public int getMyActiveIndex() {
        return myActiveIndex;
    }

    public void setMyActiveIndex(int myActiveIndex) {
        this.myActiveIndex = myActiveIndex;
    }
    
    

    public String menu(Integer i) {
        String orria = null;
        switch (i) {
            case 1:
                orria = "inicio";
                myActiveIndex=0;
                break;
            case 2:
                orria = "entradas";
                myActiveIndex=1;
                break;
            case 3:
                orria = "salidas";
                myActiveIndex=2;
                break;
            case 4:
                orria = "historial";
                myActiveIndex=3;
                break;
        }
        return orria;
    }

}

