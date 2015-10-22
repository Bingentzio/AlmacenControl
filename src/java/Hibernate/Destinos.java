package Hibernate;
// Generated 22-oct-2015 15:51:09 by Hibernate Tools 4.3.1



/**
 * Destinos generated by hbm2java
 */
public class Destinos  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String refDestino;
     private String direccion;
     private String ciudad;
     private int codigoPostal;
     private String pais;

    public Destinos() {
    }

    public Destinos(String nombre, String refDestino, String direccion, String ciudad, int codigoPostal, String pais) {
       this.nombre = nombre;
       this.refDestino = refDestino;
       this.direccion = direccion;
       this.ciudad = ciudad;
       this.codigoPostal = codigoPostal;
       this.pais = pais;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRefDestino() {
        return this.refDestino;
    }
    
    public void setRefDestino(String refDestino) {
        this.refDestino = refDestino;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public int getCodigoPostal() {
        return this.codigoPostal;
    }
    
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }




}


