/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;

import Hibernate.Producto;
import java.util.ArrayList;
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
    
    private Producto selectedproduct; //editatzeko haukeratutako produktua

    public Producto getSelectedproduct() {
        return selectedproduct;
    }

    public void setSelectedproduct(Producto selectedproduct) {
        this.selectedproduct = selectedproduct;
    }
    
    public List<Producto> getProductoZerrenda() {
        productoZerrendaLortu();
        return productoZerrenda;
    }

    public void setProductoZerrenda(List<Producto> productoZerrenda) {
        this.productoZerrenda = productoZerrenda;
    }
    
        //producto zerrenda lortu
    public void productoZerrendaLortu() {
        productoZerrenda = ProductoDao.productoList();
        System.out.println("Producto Zerrenda");
    }
        //hornitzaile bakoitzaren produktu zerrenda 
    public List<Producto> productuZerrendaHornitzailea(int id){
        List<Producto> emaitza = new ArrayList();
        for (Producto p: getProductoZerrenda()){
            if(p.getProveedorId()==id){
                emaitza.add(p);
            }
        }
        return emaitza;
    }
}
