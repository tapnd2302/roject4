/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import entity.Roles;
import exception.ObjectException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Administrator
 */
public class ObjectHelper<T> {

    protected Session session;

    public ObjectHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public void add(T obj) throws ObjectException {
        try {
            Transaction ts = this.session.beginTransaction();
            this.session.save(obj);
            ts.commit();
        } catch (Exception e) {
            throw new ObjectException(e.getMessage());
        }
    }

    public Object get(String id) {
        Transaction ts = this.session.beginTransaction();
        Object obj = (Object) this.session.get(Object.class, id);
        ts.commit();
        return obj;
    }

    public void update(T obj) throws ObjectException {
        try {
            Transaction ts = this.session.beginTransaction();
            this.session.update(obj);
            ts.commit();
        } catch (Exception e) {
            throw new ObjectException(e.getMessage());
        }

    }

    public void delete(T obj) throws ObjectException {
        try {
            Transaction ts = this.session.beginTransaction();
            this.session.delete(obj);
            ts.commit();
        } catch (Exception e) {
            throw new ObjectException(e.getMessage());
        }
    }

    public List<T> search(String name) {
        Transaction ts = this.session.beginTransaction();
        Query q = this.session.createQuery("from Book where name like :sName");
        q.setString("sName", "%" + name + "%");
        List<T> result = q.list();
        ts.commit();
        return result;
    }

    
}
