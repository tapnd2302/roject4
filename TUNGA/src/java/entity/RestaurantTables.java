package entity;
// Generated Sep 5, 2012 10:40:14 PM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * RestaurantTables generated by hbm2java
 */
public class RestaurantTables  implements java.io.Serializable {


     private int resTableId;
     private Typetable typetable;
     private Boolean statusTable;
     private Serializable tableDescription;
     private Set<Tablebooking> tablebookings = new HashSet<Tablebooking>(0);

    public RestaurantTables() {
    }

	
    public RestaurantTables(int resTableId) {
        this.resTableId = resTableId;
    }
    public RestaurantTables(int resTableId, Typetable typetable, Boolean statusTable, Serializable tableDescription, Set<Tablebooking> tablebookings) {
       this.resTableId = resTableId;
       this.typetable = typetable;
       this.statusTable = statusTable;
       this.tableDescription = tableDescription;
       this.tablebookings = tablebookings;
    }
   
    public int getResTableId() {
        return this.resTableId;
    }
    
    public void setResTableId(int resTableId) {
        this.resTableId = resTableId;
    }
    public Typetable getTypetable() {
        return this.typetable;
    }
    
    public void setTypetable(Typetable typetable) {
        this.typetable = typetable;
    }
    public Boolean getStatusTable() {
        return this.statusTable;
    }
    
    public void setStatusTable(Boolean statusTable) {
        this.statusTable = statusTable;
    }
    public Serializable getTableDescription() {
        return this.tableDescription;
    }
    
    public void setTableDescription(Serializable tableDescription) {
        this.tableDescription = tableDescription;
    }
    public Set<Tablebooking> getTablebookings() {
        return this.tablebookings;
    }
    
    public void setTablebookings(Set<Tablebooking> tablebookings) {
        this.tablebookings = tablebookings;
    }




}

