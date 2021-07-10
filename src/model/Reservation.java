package model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Reservation {
    static final String DEFAULT_DATE_FORMAT = "MM/dd/yyyy";
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
        return customer +
                "\nroom: " + room +
                "\ncheckInData: " + new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(checkInData) +
                "\ncheckOutData: " + new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(checkOutData);
    }
}
