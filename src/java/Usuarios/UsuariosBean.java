/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Hibernate.Usuarios;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import stuff.bikotea;

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

    private boolean admin = false; //saioa hasi duena administratzailea den jakiteko
    private String username; //loginean sartu duen erabiltzaile izena
    private String password; //loginean sartu duen pasahitza
    private List<Usuarios> erabiltzaileZerrenda; //erabiltzaile guztiak gordetzeko
    private Usuarios selectedUser;

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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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

    //loginean sartutako datuak konprobatzeko,zuzenak badira barrura
    public String doLogin(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message;
        boolean loggedIn;
        bikotea bik = UsuariosDao.Login(username);
        String pasahitza = bik.getPasahitza();
        if (pasahitza != null && pasahitza.equals(password)) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hola", username);
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", loggedIn);
            admin = bik.isAdmin();
            erabiltzaileZerrendaLortu();
            return "inicio";
        }
        loggedIn = false;
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Credenciales erroneas");
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        return "index";
    }

    //saioa amaitzen da botoia sakatzean
    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    //sessioan dagoen erabiltzailea ea administraria den jakiteko
    public String adminDa() {
        if (isAdmin()) {
            return "users";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "No tienes permiso para acceder");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "";
    }

    //Erabiltzaile zerrenda lortu
    public void erabiltzaileZerrendaLortu() {
        erabiltzaileZerrenda = UsuariosDao.userList();
    }

    //erabiltzailearen datuak aldatzeko
    public void erabiltzaileaEditatu() {
        UsuariosDao.userEdit(selectedUser);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Editado", "Edición Correcta!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
