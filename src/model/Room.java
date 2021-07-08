package model;

public class Room implements IRoom {
    public enum RoomType {
        SINGLE,
        DOUBLE
/*        SINGLE("1"),
        DOUBLE("2");

        public final String label;

        private RoomType(String label) {
            this.label = label;
        }

        public static RoomType valueOfLabel(String label) {
            for (RoomType roomType : values()) {
                if (roomType.label.equals(label)) {
                    return roomType;
                }
            }
            throw new IllegalArgumentException();
        }*/
    }

    private String roomNumber;
    private Double roomPrice;
    private RoomType roomType;

    public Room(String roomNumber, Double roomPrice, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.roomType = roomType;
    }

    @Override
    public String getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return this.roomPrice;
    }

    @Override
    public RoomType getRoomType() {
        return this.roomType;
    }

    @Override
    public boolean isFree() {
        return false; //?
    }

    @Override
    public String toString() {
        return "model.Room{" +
                "roomNumber= '" + this.roomNumber + '\'' +
                ", roomPrice= " + this.roomPrice +
                ", roomType= " + this.roomType +
                '}';
    }

    //test
/*    public static void main(String[] args) {
        Room myRoom = new Room("111", 100.0, RoomType.SINGLE);
        System.out.println(myRoom.toString());
    }*/
}
