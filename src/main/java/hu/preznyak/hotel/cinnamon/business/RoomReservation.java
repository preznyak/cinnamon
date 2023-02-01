package hu.preznyak.hotel.cinnamon.business;

import hu.preznyak.hotel.cinnamon.data.Guest;
import hu.preznyak.hotel.cinnamon.data.Room;

import java.util.Date;

public class RoomReservation {
    private Room room;
    private Guest guest;
    private Double price;
    private Date reservationStart;
    private Date reservationEnd;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(Date reservationStart) {
        this.reservationStart = reservationStart;
    }

    public Date getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(Date reservationEnd) {
        this.reservationEnd = reservationEnd;
    }
}
