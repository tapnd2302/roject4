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
public class TypeImageHelper<T> extends ObjectHelper<T> {
    public List<T> showTypeIMG(){
        Transaction tr = session.beginTransaction();
        Query q = session.createQuery("from Typeimages");
        List<T> result = q.list();
        tr.commit();
        return result;
    }
}
