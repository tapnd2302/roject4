/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import entity.HotelRestaurant;
import entity.RestaurantTables;
import entity.Typerooms;
import entity.Typetable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;


public class RoomsHelper<T> extends ObjectHelper<T> {
    
    public Typerooms showTypeRoom(int id){
        Transaction tr = session.beginTransaction();
        Query q = session.createQuery("from Typerooms where TypeRoomId = :id");
        q.setParameter("id", id);
        Typerooms result = (Typerooms) q.list().get(0);
        return result;
        
    }
    public HotelRestaurant showNameHotel(int id){
        Transaction tr = session.beginTransaction();
        Query q = session.createQuery("from HotelRestaurant where Hrid = :id");
        q.setParameter("id", id);
        HotelRestaurant result = (HotelRestaurant) q.list().get(0);
        return result;
        
    }
    public Typetable showTypeTable(int id){
        Transaction tr = session.beginTransaction();
        Query q = session.createQuery("from Typetable where TypeTableId = :id");
        q.setParameter("id", id);
        Typetable result = (Typetable) q.list().get(0);
        return result;
        
    }
}
