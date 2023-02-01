package hu.preznyak.hotel.cinnamon.repo;

import hu.preznyak.hotel.cinnamon.data.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
