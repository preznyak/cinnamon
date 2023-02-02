package hu.preznyak.hotel.cinnamon.util;

import hu.preznyak.hotel.cinnamon.data.Discount;
import hu.preznyak.hotel.cinnamon.service.DiscountManagementService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DiscountCalculator {
    private final DiscountManagementService discountManagementService;

    public DiscountCalculator(DiscountManagementService discountManagementService) {
        this.discountManagementService = discountManagementService;
    }

    public Integer calculateDiscountBetweenDates(Date startDate, Date endDate) {
        //List<Discount> discounts = this.discountManagementService.findByStartOfSalePeriodBeforeAndEndOfSalePeriodAfter();
        return 0;
    }
}
