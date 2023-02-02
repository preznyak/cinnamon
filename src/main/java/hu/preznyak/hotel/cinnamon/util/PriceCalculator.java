package hu.preznyak.hotel.cinnamon.util;

import hu.preznyak.hotel.cinnamon.data.Room;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class PriceCalculator {
    private final DiscountHelper discountHelper;

    public PriceCalculator(DiscountHelper discountHelper) {
        this.discountHelper = discountHelper;
    }

    public double calculatePriceForGivenPeriod(Date startDate, Date endDate, Room room) {
        long discountPercentage = discountHelper.getMaxDiscountBetweenDates(startDate, endDate);
        long differenceInMilliseconds = Math.abs(endDate.getTime() - startDate.getTime());
        long nightsToStay = TimeUnit.DAYS.convert(differenceInMilliseconds, TimeUnit.MILLISECONDS);
        return (room.getPricePerNight() * nightsToStay)*(1.0-discountPercentage/100.0);
    }
}
