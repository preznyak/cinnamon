package hu.preznyak.hotel.cinnamon.repo;

import hu.preznyak.hotel.cinnamon.data.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
