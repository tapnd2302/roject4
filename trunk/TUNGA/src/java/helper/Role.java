/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import entity.Roles;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Administrator
 */
public class Role {

    Session session = null;

    public Role() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Roles> showRole() {
        org.hibernate.Transaction tr = session.beginTransaction();
        Query q = session.createQuery("from Roles order by roleid desc");
        List<Roles> result = q.list();
        tr.commit();
        return result;
    }

    public Object insertRole(String roleName, String roleDes) {
        Object result = null;
        try {
            Transaction tr = session.beginTransaction();
            Roles r = new Roles();
            r.setRoleName(roleName);
            r.setDescriptions(roleDes);

            result = session.save(r);
            tr.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
        
    }
    public Object deleteRole(Roles r){
        Object result = null;
        try{
            Transaction tr = session.beginTransaction();
            session.delete(r);
            tr.commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
