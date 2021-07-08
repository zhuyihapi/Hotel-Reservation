package model;

import java.util.Date;

public class Reservation {
    Customer customer;
    IRoom room;
    Date checkInData;
    Date checkOutData;

    public Reservation(Customer customer, IRoom room, Date checkInData, Date checkOutData) {
        this.customer = customer;
        this.room = room;
        this.checkInData = checkInData;
        this.checkOutData = checkOutData;
    }

    public Reservation findAReservation(Date checkInData, Date checkOutData){
        if (this.checkInData.equals(checkInData) && this.checkOutData.equals(checkOutData)){
            return this;
        }else{
            return null;
        }
    }

    @Override
    public String toString() {
        return "model.Reservation{" +
                "customer=" + customer +
                ", room=" + room +
                ", checkInData=" + checkInData +
                ", checkOutData=" + checkOutData +
                '}';
    }
}
