/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import entity.Images;
import entity.Typeimages;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author KyHuu
 */
public class ImagesHelper<T> extends ObjectHelper<T> {
     public List<T> showIMG() {
        Transaction ts = this.session.beginTransaction();
        Query q = this.session.createQuery("from Images");
        List<T> result = q.list();
        ts.commit();
        return result;
    }
     public Images showIMGConditional(int id) {
         
        Transaction ts = this.session.beginTransaction();
//        Query q = this.session.createQuery("select object(o) from Images o where o.typeimages.typeImageId = :type and o.id = :id");
        Query q = this.session.createQuery(" from Images i where i.typeimages.typeImageId = 4 and Id = :id");
        q.setParameter("id", id);
        List<T> result = q.list();
//        ts.commit();
        if(result.size() > 0)
            return (Images) result.get(0);
        else 
            return null;
    }
}
