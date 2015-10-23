/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Hibernate.Usuarios;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author bingen
 */
@ManagedBean
@SessionScoped
public class UsuariosBean implements java.io.Serializable {

    /**
     * Creates a new instance of UsuariosBean
     */
    public UsuariosBean() {
    }
    private String username; //loginean sartu duen erabiltzaile izena
    private String password; //loginean sartu duen pasahitza
    private List<Usuarios> erabiltzaileZerrenda; //erabiltzaile guztiak gordetzeko
    private Usuarios selectedUser; //editatzeko hautatzen den erabiltzailea
    private Usuarios logedUser; //saioa hasi duen erabiltzailea

    public Usuarios getLogedUser() {
        return logedUser;
    }

    public void setLogedUser(Usuarios logedUser) {
        this.logedUser = logedUser;
    }

    public Usuarios getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(Usuarios selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<Usuarios> getErabiltzaileZerrenda() {
        return erabiltzaileZerrenda;
    }

    public void setErabiltzaileZerrenda(List<Usuarios> erabiltzaileZerrenda) {
        this.erabiltzaileZerrenda = erabiltzaileZerrenda;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //login egiteko
    public String Login() {
        FacesMessage message;
        for (Usuarios u : erabiltzaileZerrenda) {
            if (username != null && password != null && u.getUsername().equals(username) && u.getPassword().equals(password)) {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hola", username);
                FacesContext.getCurrentInstance().addMessage(null, message);
                logedUser=u;
                return "inicio";
            }
        }
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Credenciales erroneas");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "index";
    }

    //saioa amaitzen da botoia sakatzean
    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    //sessioan dagoen erabiltzailea ea administraria den jakiteko
    public String adminDa() {
        if (logedUser.isAdmin()) {
            return "users";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "No tienes permiso para acceder");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "";
    }

    //Erabiltzaile zerrenda lortu
    public void erabiltzaileZerrendaLortu() {
        erabiltzaileZerrenda = UsuariosDao.userList();
        System.out.println(1);
    }

    //erabiltzailearen datuak aldatzeko
    public void erabiltzaileaEditatu() {
        UsuariosDao.userEdit(selectedUser);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Editado", "Edición Correcta!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
