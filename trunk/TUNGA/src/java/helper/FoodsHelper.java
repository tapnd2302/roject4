/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import entity.Foods;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author HP
 */
public class FoodsHelper<T> {
    protected Session session;

    public FoodsHelper() {
       this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Foods> getFoods() {
        Transaction tr = this.session.beginTransaction();
        Query q = this.session.createQuery("From Foods");
        List<Foods> result = q.list();
        tr.commit();
        return result;
    }
   
    
}
