package hu.preznyak.hotel.cinnamon.data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private long id;
    @Column(name = "ROOM_ID")
    private long roomId;
    @Column(name = "GUEST_ID")
    private long guestId;
    @Column(name = "RES_DATE_START")
    private Date reservationDateStart;
    @Column(name = "RES_DATE_END")
    private Date reservationDateEnd;
    @Column(name = "PRICE")
    private Double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public Date getReservationDateStart() {
        return reservationDateStart;
    }

    public void setReservationDateStart(Date reservationDateStart) {
        this.reservationDateStart = reservationDateStart;
    }

    public Date getReservationDateEnd() {
        return reservationDateEnd;
    }

    public void setReservationDateEnd(Date reservationDateEnd) {
        this.reservationDateEnd = reservationDateEnd;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
