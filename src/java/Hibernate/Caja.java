package Hibernate;
// Generated 23-oct-2015 10:33:54 by Hibernate Tools 4.3.1



/**
 * Caja generated by hbm2java
 */
public class Caja  implements java.io.Serializable {


     private Integer id;
     private int numero;
     private int productoId;
     private int albaranEntradaId;
     private int albaranSalidaId;
     private int peso;
     private String observacion;
     private boolean estado;
     private boolean activo;
     private int unidades;

    public Caja() {
    }

    public Caja(int numero, int productoId, int albaranEntradaId, int albaranSalidaId, int peso, String observacion, boolean estado, boolean activo, int unidades) {
       this.numero = numero;
       this.productoId = productoId;
       this.albaranEntradaId = albaranEntradaId;
       this.albaranSalidaId = albaranSalidaId;
       this.peso = peso;
       this.observacion = observacion;
       this.estado = estado;
       this.activo = activo;
       this.unidades = unidades;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getNumero() {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getProductoId() {
        return this.productoId;
    }
    
    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }
    public int getAlbaranEntradaId() {
        return this.albaranEntradaId;
    }
    
    public void setAlbaranEntradaId(int albaranEntradaId) {
        this.albaranEntradaId = albaranEntradaId;
    }
    public int getAlbaranSalidaId() {
        return this.albaranSalidaId;
    }
    
    public void setAlbaranSalidaId(int albaranSalidaId) {
        this.albaranSalidaId = albaranSalidaId;
    }
    public int getPeso() {
        return this.peso;
    }
    
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public int getUnidades() {
        return this.unidades;
    }
    
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }




}


