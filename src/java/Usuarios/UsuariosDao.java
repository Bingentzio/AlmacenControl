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
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import stuff.bikotea;

/**
 *
 * @author bingen
 */
public class UsuariosDao {
    
    public static bikotea Login(String username) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Usuarios> emaitza = new ArrayList<Usuarios>();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Usuarios as u where u.user = '" + username + "' ");
            emaitza = q.list();
            session.getTransaction().commit();
            if (emaitza.isEmpty()) {
                return new bikotea(null,false);
            }
        } catch (Exception e) {
            System.err.print(e);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error(login)");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            session.getTransaction().rollback();
        }
        return new bikotea(emaitza.get(0).getPassword(), emaitza.get(0).isAdmin());
    }
    
    public static List<Usuarios> userList() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Usuarios> emaitza = new ArrayList<Usuarios>();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Usuarios.class);
            emaitza = criteria.list();
            session.getTransaction().commit();
            if (emaitza.isEmpty()) {
                return null;
            }
        } catch (Exception e) {
            System.err.print(e);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error(userList)");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            session.getTransaction().rollback();
        }
        return emaitza;
    }

    public static void userEdit(Usuarios selectedUser) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();       
        try {
            session.beginTransaction();
            session.update(selectedUser);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.print(e);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error(userEdit)");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            session.getTransaction().rollback();
        }
    }
    
}
