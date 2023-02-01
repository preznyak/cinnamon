package hu.preznyak.hotel.cinnamon.controller;

import hu.preznyak.hotel.cinnamon.business.RoomReservation;
import hu.preznyak.hotel.cinnamon.data.Reservation;
import hu.preznyak.hotel.cinnamon.service.ReservationManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationManagementService reservationManagementService;

    public ReservationController(ReservationManagementService reservationManagementService) {
        this.reservationManagementService = reservationManagementService;
    }

    @GetMapping
    public ResponseEntity<List<RoomReservation>> getRoomReservations() {
        return new ResponseEntity<>(this.reservationManagementService.getAllReservation(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(this.reservationManagementService.createReservation(reservation), HttpStatus.CREATED);
    }
}
