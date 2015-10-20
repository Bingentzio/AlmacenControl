/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Hibernate.HibernateUtil;
import Hibernate.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author bingen
 */


public class UsuariosDao {

    
    public static String Login(String username){
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Usuarios> emaitza = new ArrayList<Usuarios>();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Usuarios as u where u.user = '" + username + "' ");
            emaitza = q.list();
            session.getTransaction().commit();
            if (emaitza.isEmpty()) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no existe!", "Try again :" + username);
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return null;
            }
        } catch (Exception e) {
                   System.err.print(e);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error(login)");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            session.getTransaction().rollback(); 
        }
    
        return emaitza.get(0).getPassword();
    }
    
        
}
