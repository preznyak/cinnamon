package hu.preznyak.hotel.cinnamon.repo;

import hu.preznyak.hotel.cinnamon.data.Discount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DiscountRepository extends CrudRepository<Discount, Long> {
    List<Discount> findByStartOfSalePeriodAfter(Date date);
    List<Discount> findByEndOfSalePeriodBefore(Date date);

    List<Discount> findByStartOfSalePeriodBeforeAndEndOfSalePeriodAfter(Date startDate, Date endDate);
}
