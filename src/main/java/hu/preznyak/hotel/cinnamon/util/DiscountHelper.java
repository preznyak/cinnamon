package hu.preznyak.hotel.cinnamon.util;

import hu.preznyak.hotel.cinnamon.data.Discount;
import hu.preznyak.hotel.cinnamon.service.DiscountManagementService;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class DiscountHelper {
    private final DiscountManagementService discountManagementService;

    public DiscountHelper(DiscountManagementService discountManagementService) {
        this.discountManagementService = discountManagementService;
    }

    public Integer getMaxDiscountBetweenDates(Date startDate, Date endDate) {
        List<Discount> discounts = this.discountManagementService.findByStartOfSalePeriodBeforeAndEndOfSalePeriodAfter(startDate, endDate);
        Discount maxDiscount = discounts.stream()
                .max(Comparator.comparing(Discount::getDiscountPercentage))
                .orElse(new Discount());
        if (Objects.isNull(maxDiscount.getDiscountPercentage())) {
            return 0;
        } else {
            return maxDiscount.getDiscountPercentage();
        }
    }
}
