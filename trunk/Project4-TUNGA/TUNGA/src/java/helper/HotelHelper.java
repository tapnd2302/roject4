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
    public List<T> showImage(int typeImg, int id){
        org.hibernate.Transaction tr = session.beginTransaction();
        Query q = session.createQuery("From Images where TypeImage = :typeImg and ID = :id");
        q.setParameter("typeImg", typeImg);
        q.setParameter("id", id);
        List<T> result = q.list();
        tr.commit();
        return result;
    }
    public List<T> showTypeRoom(){
        org.hibernate.Transaction tr = session.beginTransaction();
        Query q = session.createQuery("From Typerooms");
        List<T> result = q.list();
        tr.commit();
        return result;
    }
    public List<T> showRooms(){
        org.hibernate.Transaction tr = session.beginTransaction();
        Query q = session.createQuery("From Rooms");
        List<T> result = q.list();
        tr.commit();
        return result;
    }
    
    public List<T> showTypeTable(){
        org.hibernate.Transaction tr = session.beginTransaction();
        Query q = session.createQuery("From Typetable");
        List<T> result = q.list();
        tr.commit();
        return result;
    }
    
    public List<T> showTable(){
        org.hibernate.Transaction tr = session.beginTransaction();
        Query q = session.createQuery("From RestaurantTables");
        List<T> result = q.list();
        tr.commit();
        return result;
    }
}
