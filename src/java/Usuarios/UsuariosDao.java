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
import org.hibernate.Session;

/**
 *
 * @author bingen
 */
public class UsuariosDao {

    public static List<Usuarios> userList() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Usuarios> emaitza = new ArrayList<Usuarios>();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Usuarios.class);
            emaitza = criteria.list();
            session.getTransaction().commit();
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
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error(editUser)");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            session.getTransaction().rollback();
        }
    }

    public static void saveUser(Usuarios newUser) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(newUser);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.print(e);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error(newUser)");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            session.getTransaction().rollback();
        }
    }

    public static void deleteUser(Usuarios selectedUser) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(selectedUser);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.print(e);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error(delUser)");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            session.getTransaction().rollback();
        }
    }

}