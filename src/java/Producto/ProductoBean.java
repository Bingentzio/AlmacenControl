/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;

import Hibernate.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author Bingen
 */
@ManagedBean
@SessionScoped
public class ProductoBean implements java.io.Serializable {

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
    }
    
    private List<Producto> productoZerrenda;  
    private Producto selectedProduct; //editatzeko haukeratutako produktua
    private Producto newProduct= new Producto();//Productu berria sortzeko

    public Producto getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Producto selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Producto getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Producto newProduct) {
        this.newProduct = newProduct;
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
    
    
    //Productuaren datuak aldatzeko
    public void productuaEditatu() {
        ProductoDao.productEdit(selectedProduct);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Editado", "El producto ha sido editado!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    //Productu berria sortzeko
    public void productuBerria(){
        ProductoDao.saveProduct(newProduct);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nuevo", "Has creado un nuevo producto!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    // aukeratutako productua ezabatzeko
    public void productuaEzabatu(){
        ProductoDao.deleteProduct(selectedProduct);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "El producto ha sido eliminado!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
