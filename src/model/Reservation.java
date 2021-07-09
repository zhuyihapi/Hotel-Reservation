package model;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInData;
    private Date checkOutData;

    public Reservation(Customer customer, IRoom room, Date checkInData, Date checkOutData) {
        this.customer = customer;
        this.room = room;
        this.checkInData = checkInData;
        this.checkOutData = checkOutData;
    }

    public Customer getCustomer() {
        return customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public Date getCheckInData() {
        return checkInData;
    }

    public Date getCheckOutData() {
        return checkOutData;
    }

    @Override
    public String toString() {
        return "customer: " + customer +
                ", room: " + room +
                ", checkInData: " + checkInData +
                ", checkOutData: " + checkOutData;
    }
}
