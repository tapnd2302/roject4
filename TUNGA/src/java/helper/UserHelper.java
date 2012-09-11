/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class UserHelper<T> extends ObjectHelper<T> {
    public List<T> showRole(){
        List<T> result = null;
        Transaction tr = session.beginTransaction();
        Query q = session.createQuery("from Roles");
        result = q.list();
        tr.commit();
        return result;
    } 
}
