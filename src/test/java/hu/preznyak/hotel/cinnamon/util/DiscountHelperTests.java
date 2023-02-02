package hu.preznyak.hotel.cinnamon.util;

import hu.preznyak.hotel.cinnamon.data.Discount;
import hu.preznyak.hotel.cinnamon.service.DiscountManagementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DiscountHelperTests {
    @InjectMocks
    private DiscountHelper discountHelper;
    @Mock
    private DiscountManagementService discountManagementService;

    @Test
    void testGetDiscountBetweenDates() throws ParseException {
        //Given
        Integer expectedDiscount = 20;
        Discount mockDiscountMax = new Discount();
        mockDiscountMax.setDiscountPercentage(expectedDiscount);
        Discount otherDiscount = new Discount();
        otherDiscount.setDiscountPercentage(15);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = simpleDateFormat.parse("2023-01-02");
        Date endDate = simpleDateFormat.parse("2023-01-07");

        Mockito.when(discountManagementService.findByStartOfSalePeriodBeforeAndEndOfSalePeriodAfter(startDate, endDate)).thenReturn(List.of(mockDiscountMax, otherDiscount));

        //When
        Integer actualDiscountPercentage = discountHelper.getMaxDiscountBetweenDates(startDate, endDate);

        //Then
        Assertions.assertEquals(expectedDiscount, actualDiscountPercentage);
    }


}
