package model;

public interface IRoom {
    public String getRoomNumber();
    public Double getRoomPrice();
    public Room.RoomType getRoomType();
    public boolean isFree();
}
