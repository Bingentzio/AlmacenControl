/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.awt.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author bingen
 */
@ManagedBean
@SessionScoped
public class UsuariosBean implements java.io.Serializable{

    /**
     * Creates a new instance of UsuariosBean
     */
    public UsuariosBean() {
    }
    private String username;
     
    private String password;
 
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
   
    public String doLogin(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        String pasahitza=UsuariosDao.Login(username);
        if(pasahitza!=null && pasahitza.equals(password)){
            loggedIn=true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hola", username);
            FacesContext.getCurrentInstance().addMessage(null, message);            
            context.addCallbackParam("loggedIn", loggedIn);
            return "inicio";         
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }        
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        return "index";
    }
    
}
