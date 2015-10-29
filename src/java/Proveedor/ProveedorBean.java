/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proveedor;

import Hibernate.Proveedor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Bingen
 */
@ManagedBean
@ViewScoped
public class ProveedorBean implements java.io.Serializable {

    /**
     * Creates a new instance of ProveedorBean
     */
    public ProveedorBean() {
    }

    private List<Proveedor> proveedoreZerrenda;

    public List<Proveedor> getProveedoreZerrenda() {
        proveedoreZerrendaLortu();
        return proveedoreZerrenda;
    }

    public void setProveedoreZerrenda(List<Proveedor> proveedoreZerrenda) {
        this.proveedoreZerrenda = proveedoreZerrenda;
    }

    //Proveedoreen zerrenda lortu
    public void proveedoreZerrendaLortu() {
        proveedoreZerrenda = ProveedorDao.proveedorList();
        System.out.println("Proveedore Zerrenda Lortu");
    }
}
