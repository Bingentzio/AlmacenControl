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
import javax.faces.bean.ViewScoped;



/**
 *
 * @author Bingen
 */
@ManagedBean
@ViewScoped
public class ProductoBean implements java.io.Serializable {

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
    }
    
    private List<Producto> productoZerrenda;  
    private Producto selectedProduct;//editatzeko haukeratutako produktua
    private Producto newProduct= new Producto();//Productu berria sortzeko
    
    private int idProv = 1;

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }

    public Producto getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Producto selectedProduct) {
        System.out.println("Selected: " + selectedProduct );
        this.selectedProduct = selectedProduct;
    }

    public Producto getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Producto newProduct) {
        this.newProduct = newProduct;
    }
    
    public List<Producto> getProductoZerrenda() {
        return productoZerrenda;
    }

    public void setProductoZerrenda(List<Producto> productoZerrenda) {
        this.productoZerrenda = productoZerrenda;
    }
    
        //producto zerrenda lortu
    public void productoZerrendaLortu() {
        productoZerrenda = ProductoDao.productoList();
        System.out.println("Producto Zerrenda Lortu");
    }
        //hornitzaile bakoitzaren produktu zerrenda 
    public List<Producto> productuZerrendaHornitzailea(int id){
        System.out.println("Produktu zerrenda hornitzailea");
        productoZerrendaLortu();
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
        //productoZerrendaLortu();
    }
    //Productu berria sortzeko
    public void productuBerria(){
        Producto p = getNewProduct();
        p.setImagen("ez");
        ProductoDao.saveProduct(p);
        //productoZerrendaLortu();
    }
    // aukeratutako productua ezabatzeko
    public void productuaEzabatu(){
        ProductoDao.deleteProduct(selectedProduct);
        //productoZerrendaLortu();
    }
}
