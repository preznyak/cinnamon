package hu.preznyak.hotel.cinnamon.util;

import hu.preznyak.hotel.cinnamon.data.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class PriceCalculatorTests {
    @InjectMocks
    private PriceCalculator priceCalculator;
    @Mock
    private DiscountHelper discountHelper;

    @Test
    void testCalculatePriceForGivenPeriod() throws ParseException {
        //Given
        Integer discount = 20;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = simpleDateFormat.parse("2023-01-02");
        Date endDate = simpleDateFormat.parse("2023-01-07");

        Mockito.when(discountHelper.getMaxDiscountBetweenDates(startDate, endDate)).thenReturn(discount);
        double expectedPrice = 160.0;
        //When
        double calculatedPriceWithDiscount = priceCalculator.calculatePriceForGivenPeriod(startDate, endDate, getTestRoom());

        //Then
        Assertions.assertEquals(expectedPrice, calculatedPriceWithDiscount);
    }

    private Room getTestRoom() {
        Room room = new Room();
        room.setName("Test");
        room.setCapacity(4);
        room.setPricePerNight(40);
        room.setBedInfo("1K");
        room.setType("Standard");
        room.setRoomNumber("10T");
        return room;
    }
}
