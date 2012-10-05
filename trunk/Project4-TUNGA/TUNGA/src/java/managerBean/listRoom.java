
package managerBean;

import entity.Rooms;
import entity.Typerooms;
import helper.HotelHelper;
import helper.ObjectHelper;
import helper.RoomsHelper;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class listRoom {
    
    private List<Rooms> listRoom;
    private List<Rooms> filteredCars;
    
    
    

    public List<Rooms> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<Rooms> filteredCars) {
        this.filteredCars = filteredCars;
    }

    public List<Rooms> getListRoom() {
        return listRoom;
    }

    public void setListRoom(List<Rooms> listRoom) {
        this.listRoom = listRoom;
    }
   
    public listRoom() {
        HotelHelper<Rooms> roomHelper = new HotelHelper<Rooms>();
        listRoom = roomHelper.showRooms();
    }
    
    public String selTypeRoom(int idTypeRoom){
        RoomsHelper<Rooms> roomHelper = new RoomsHelper<Rooms>();
        Typerooms tr = new Typerooms();
        tr = roomHelper.showTypeRoom(idTypeRoom);
        return tr.getTypeRoomName();
    }
}
