package model;

import model.Room;

public class FreeRoom extends Room {
    public FreeRoom(String roomNumber, Double roomPrice, RoomType roomType) {
        super(roomNumber, 0.0 , roomType);
    }

    @Override
    public boolean isFree() {
        return true;
    } // ?

    @Override
    public String toString() {
        return "free room: "+super.toString();
    }
}
