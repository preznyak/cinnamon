package hu.preznyak.hotel.cinnamon.service;

import hu.preznyak.hotel.cinnamon.data.Room;
import hu.preznyak.hotel.cinnamon.repo.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoomManagementService {
    private final RoomRepository roomRepository;

    public RoomManagementService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAllRooms (){
        List<Room> roomList = new ArrayList<>();
        Iterable<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(roomList::add);
        roomList.sort(Comparator.comparing(Room::getRoomNumber));
        return roomList;
    }

    public Room addRoom(Room room) {
        if(Objects.isNull(room)) {
            throw new UnsupportedOperationException("Room can not be null");
        }
        return this.roomRepository.save(room);
    }

    public Room updateRoom(Room room) {
        if(Objects.isNull(room)) {
            throw new UnsupportedOperationException("Room can not be null");
        }
        Room savedRoom = this.roomRepository.findById(room.getId()).orElseThrow(
                () -> new NoSuchElementException("No room found with the given ID.")
        );
        savedRoom.setBedInfo(room.getBedInfo());
        savedRoom.setCapacity(room.getCapacity());
        savedRoom.setName(room.getName());
        return this.roomRepository.save(savedRoom);
    }

    public void deleteRoom(Long roomId) {
        this.roomRepository.findById(roomId).orElseThrow(
                () -> new NoSuchElementException("No room found with the given ID.")
        );
        this.roomRepository.deleteById(roomId);
    }
}
