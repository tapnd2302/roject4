package entity;
// Generated Sep 5, 2012 10:40:14 PM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Typefoods generated by hbm2java
 */
public class Typefoods  implements java.io.Serializable {


     private int typeFoodId;
     private Serializable typeFoodName;
     private Serializable typeFoodDescription;
     private Set<Foods> foodses = new HashSet<Foods>(0);

    public Typefoods() {
    }

	
    public Typefoods(int typeFoodId) {
        this.typeFoodId = typeFoodId;
    }
    public Typefoods(int typeFoodId, Serializable typeFoodName, Serializable typeFoodDescription, Set<Foods> foodses) {
       this.typeFoodId = typeFoodId;
       this.typeFoodName = typeFoodName;
       this.typeFoodDescription = typeFoodDescription;
       this.foodses = foodses;
    }
   
    public int getTypeFoodId() {
        return this.typeFoodId;
    }
    
    public void setTypeFoodId(int typeFoodId) {
        this.typeFoodId = typeFoodId;
    }
    public Serializable getTypeFoodName() {
        return this.typeFoodName;
    }
    
    public void setTypeFoodName(Serializable typeFoodName) {
        this.typeFoodName = typeFoodName;
    }
    public Serializable getTypeFoodDescription() {
        return this.typeFoodDescription;
    }
    
    public void setTypeFoodDescription(Serializable typeFoodDescription) {
        this.typeFoodDescription = typeFoodDescription;
    }
    public Set<Foods> getFoodses() {
        return this.foodses;
    }
    
    public void setFoodses(Set<Foods> foodses) {
        this.foodses = foodses;
    }




}

