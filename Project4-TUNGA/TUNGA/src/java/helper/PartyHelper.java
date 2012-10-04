/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import entity.Bookingparty;
import exception.ObjectException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author HP
 */
public class PartyHelper<T> {
    protected Session session;
    public PartyHelper() {
         this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public void add(T ojb) throws ObjectException {
            try {
            Transaction ts = this.session.beginTransaction();
            this.session.save(ojb);
            ts.commit();
            } catch (Exception e) {
             throw new ObjectException(e.getMessage());
            }
    }
    
    
}
