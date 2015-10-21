/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author bingen
 */
@ManagedBean
@SessionScoped
public class ProductoBean implements java.io.Serializable {

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
    }

    public String menu(Integer i) {
        String orria = null;
        switch (i) {
            case 1:
                orria = "inicio";
                break;
            case 2:
                orria = "entradas";
                break;
            case 3:
                orria = "salidas";
                break;
            case 4:
                orria = "historial";
                break;
        }
        return orria;
    }

}
