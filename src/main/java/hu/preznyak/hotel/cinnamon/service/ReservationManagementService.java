package hu.preznyak.hotel.cinnamon.service;

import hu.preznyak.hotel.cinnamon.business.RoomReservation;
import hu.preznyak.hotel.cinnamon.data.Reservation;
import hu.preznyak.hotel.cinnamon.data.Room;
import hu.preznyak.hotel.cinnamon.repo.GuestRepository;
import hu.preznyak.hotel.cinnamon.repo.ReservationRepository;
import hu.preznyak.hotel.cinnamon.repo.RoomRepository;
import hu.preznyak.hotel.cinnamon.util.DiscountHelper;
import hu.preznyak.hotel.cinnamon.util.PriceCalculator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReservationManagementService {
    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final PriceCalculator priceCalculator;

    public ReservationManagementService(ReservationRepository reservationRepository, GuestRepository guestRepository, RoomRepository roomRepository, PriceCalculator priceCalculator) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.priceCalculator = priceCalculator;
    }

    public Reservation createReservation(Reservation reservation) {
        Room room = this.roomRepository.findById(reservation.getRoomId()).orElseThrow(
                () -> new NoSuchElementException("Room not found.")
        );
        reservation.setPrice(this.priceCalculator.calculatePriceForGivenPeriod(reservation.getReservationDateStart(), reservation.getReservationDateEnd(), room));
        return this.reservationRepository.save(reservation);
    }

    public void deleteReservation(long reservationId) {
        Reservation reservation = this.reservationRepository.findById(reservationId)
                .orElseThrow(() -> new NoSuchElementException("Reservation not found for the given ID."));
        this.reservationRepository.deleteById(reservationId);
    }

    public Reservation updateReservation(Reservation reservation) {
        Reservation savedReservation = this.reservationRepository.findById(reservation.getId())
                .orElseThrow(() -> new NoSuchElementException("Reservation not found for the given ID."));
        savedReservation.setReservationDateStart(reservation.getReservationDateStart());
        savedReservation.setReservationDateEnd(reservation.getReservationDateEnd());
        return this.reservationRepository.save(savedReservation);
    }

    public List<RoomReservation> getAllReservation() {
        List<RoomReservation> roomReservationList = new ArrayList<>();
        Iterable<Reservation> reservations = this.reservationRepository.findAll();
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setReservationStart(reservation.getReservationDateStart());
            roomReservation.setReservationEnd(reservation.getReservationDateEnd());
            roomReservation.setPrice(reservation.getPrice());
            roomReservation.setRoom(this.roomRepository.findById(reservation.getRoomId()).get());
            roomReservation.setGuest(this.guestRepository.findById(reservation.getGuestId()).get());
            roomReservationList.add(roomReservation);
        });
        return roomReservationList;
    }
}
