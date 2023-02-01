package hu.preznyak.hotel.cinnamon.repo;

import hu.preznyak.hotel.cinnamon.data.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
}
