/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;

import Hibernate.Producto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Bingen
 */
@ManagedBean
@SessionScoped
public class ProductoBean {

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
    }
    
    private List<Producto> productoZerrenda;

    public List<Producto> getProductoZerrenda() {
        return productoZerrenda;
    }

    public void setProductoZerrenda(List<Producto> productoZerrenda) {
        this.productoZerrenda = productoZerrenda;
    }
    
        //producto zerrenda lortu
    public void erabiltzaileZerrendaLortu() {
        productoZerrenda = ProductoDao.productoList();
        System.out.println("Producto Zerrenda");
    }
}
