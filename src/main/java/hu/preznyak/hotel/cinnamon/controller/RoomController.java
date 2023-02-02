package hu.preznyak.hotel.cinnamon.controller;

import hu.preznyak.hotel.cinnamon.data.Room;
import hu.preznyak.hotel.cinnamon.service.RoomManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomManagementService roomManagementService;

    public RoomController(RoomManagementService roomManagementService) {
        this.roomManagementService = roomManagementService;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return this.roomManagementService.findAllRooms();
    }

    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        return new ResponseEntity<>(this.roomManagementService.addRoom(room), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {
        return new ResponseEntity<>(this.roomManagementService.updateRoom(room), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRoom(@RequestParam(value = "roomId") long roomId) {
        this.roomManagementService.deleteRoom(roomId);
        return new ResponseEntity<>("The room was deleted successfully.", HttpStatus.OK);
    }

    @ResponseStatus
    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<String> unsupportedOperation(UnsupportedOperationException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElement(NoSuchElementException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
