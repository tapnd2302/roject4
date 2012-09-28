/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import entity.HotelRestaurant;
import java.util.List;
import org.hibernate.Query;


public class HotelHelper<T> extends ObjectHelper<T> {
    public List<T> showHR(){
        org.hibernate.Transaction tr = session.beginTransaction();
        Query q = session.createQuery("From HotelRestaurant");
        List<T> result = q.list();
        tr.commit();
        return result;
    }
    public List<T> showImage(int id){
        org.hibernate.Transaction tr = session.beginTransaction();
        Query q = session.createQuery("From Images where TypeImage = 2 and ID = :id");
        q.setParameter("id", id);
        List<T> result = q.list();
        tr.commit();
        return result;
    }
}
