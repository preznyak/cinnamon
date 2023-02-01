package hu.preznyak.hotel.cinnamon.controller;

import hu.preznyak.hotel.cinnamon.data.Guest;
import hu.preznyak.hotel.cinnamon.service.GuestManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/guests")
public class GuestController {
    private final GuestManagementService guestManagementService;

    public GuestController(GuestManagementService guestManagementService) {
        this.guestManagementService = guestManagementService;
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuest(){
        return new ResponseEntity<>(this.guestManagementService.findAllGuest(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Guest> addNewGuest(@RequestBody Guest guest) {
        return new ResponseEntity<>(this.guestManagementService.addGuest(guest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest) {
        return new ResponseEntity<>(this.guestManagementService.updateGuest(guest), HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteGuest(@RequestParam long guestId) {
        this.guestManagementService.deleteGuest(guestId);
        return new ResponseEntity<>("Guest successfully deleted.", HttpStatus.ACCEPTED);
    }

    @ResponseStatus
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElement(NoSuchElementException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus
    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<String> unsupportedOperation(UnsupportedOperationException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
