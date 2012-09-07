/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import entity.Roles;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Administrator
 */
public class RoleHelper<T> extends ObjectHelper<T> {
    public List<T> showRole() {
        org.hibernate.Transaction tr = session.beginTransaction();
        Query q = session.createQuery("from Roles");
        List<T> result = q.list();
        tr.commit();
        return result;
    }
        public List<T> showRoleDesc() {
        org.hibernate.Transaction tr = session.beginTransaction();
        Query q = session.createQuery("from Roles order by roleid desc");
        List<T> result = q.list();
        tr.commit();
        return result;
    }
}
