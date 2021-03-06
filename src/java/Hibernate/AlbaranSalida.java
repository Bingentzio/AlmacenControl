package Hibernate;
// Generated 22-oct-2015 15:51:09 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * AlbaranSalida generated by hbm2java
 */
public class AlbaranSalida  implements java.io.Serializable {


     private Integer id;
     private String numeroAlbaran;
     private String numeroPedido;
     private Date fecha;
     private int destinoId;

    public AlbaranSalida() {
    }

    public AlbaranSalida(String numeroAlbaran, String numeroPedido, Date fecha, int destinoId) {
       this.numeroAlbaran = numeroAlbaran;
       this.numeroPedido = numeroPedido;
       this.fecha = fecha;
       this.destinoId = destinoId;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumeroAlbaran() {
        return this.numeroAlbaran;
    }
    
    public void setNumeroAlbaran(String numeroAlbaran) {
        this.numeroAlbaran = numeroAlbaran;
    }
    public String getNumeroPedido() {
        return this.numeroPedido;
    }
    
    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getDestinoId() {
        return this.destinoId;
    }
    
    public void setDestinoId(int destinoId) {
        this.destinoId = destinoId;
    }




}


