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
 * @author KyHuu
 */
public class TypeFoodHelper<T> extends ObjectHelper<T> {
    public List<T> showTypeFood(){
        Transaction tr = session.beginTransaction();
        Query q = session.createQuery("from Typefoods");
        List<T> result = q.list();
        tr.commit();
        return result;
    }
    public List<T> showTypeFoodCondition(String id){
        Transaction tr = session.beginTransaction();
        Query q = session.createQuery("from Typefoods where TypeFoodId = :id");
        q.setParameter("id", id);
        List<T> result = q.list();
        tr.commit();
        return result;
    }
    
}
