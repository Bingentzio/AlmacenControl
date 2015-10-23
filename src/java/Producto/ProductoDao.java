/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;

import Hibernate.HibernateUtil;
import Hibernate.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Bingen
 */
public class ProductoDao {

    public static List<Producto> productoList() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Producto> emaitza = new ArrayList<Producto>();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Producto.class);
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
}
