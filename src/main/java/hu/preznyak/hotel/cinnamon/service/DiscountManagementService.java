package hu.preznyak.hotel.cinnamon.service;

import hu.preznyak.hotel.cinnamon.data.Discount;
import hu.preznyak.hotel.cinnamon.repo.DiscountRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DiscountManagementService {
    private final DiscountRepository discountRepository;

    public DiscountManagementService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public Discount createDiscount(Discount discount) {
        if(Objects.isNull(discount)){
            throw new UnsupportedOperationException("Discount cannot be null.");
        }
        return this.discountRepository.save(discount);
    }

    public List<Discount> getAllDiscount() {
        List<Discount> discountList = new ArrayList<>();
        Iterable<Discount> discounts = this.discountRepository.findAll();
        discounts.forEach(discountList::add);
        discountList.sort(Comparator.comparing(Discount::getStartOfSalePeriod));
        return discountList;
    }

    public List<Discount> findAllAfterStartDate(Date date) {
        return this.discountRepository.findByStartOfSalePeriodAfter(date);
    }

    public List<Discount> findAllBeforeEndDate(Date date){
        return this.discountRepository.findByEndOfSalePeriodBefore(date);
    }

    public List<Discount> findByStartOfSalePeriodBeforeAndEndOfSalePeriodAfter(Date startDate, Date endDate){
        return this.discountRepository.findByStartOfSalePeriodBeforeAndEndOfSalePeriodAfter(startDate, endDate);
    }
}
