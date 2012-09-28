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
 * @author HP
 */
public class FoodsHelper<T> extends ObjectHelper<T> {

    public List<T> getFoods() {
        Transaction tr = session.beginTransaction();
        Query q = session.createQuery("from Foods");
        List<T> result = q.list();
        tr.commit();
        return result;
    }
    public List<T> getFoodsMaxID() {
        Transaction tr = session.beginTransaction();
        Query q = session.createQuery("from Foods order by FoodId desc");
        List<T> result = q.list();
        tr.commit();
        
        return result;
    }
    
   
    
}
