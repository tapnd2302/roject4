/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import entity.Typerooms;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;


public class RoomsHelper<T> extends ObjectHelper<T> {
    
    public Typerooms showTypeRoom(int id){
        Transaction tr = session.beginTransaction();
        Typerooms obj = (Typerooms) this.session.get(Typerooms.class, id);
        tr.commit();
        return obj;
        
    }
    
    
}
