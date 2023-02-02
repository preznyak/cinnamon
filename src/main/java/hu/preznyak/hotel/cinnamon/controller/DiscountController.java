package hu.preznyak.hotel.cinnamon.controller;

import hu.preznyak.hotel.cinnamon.data.Discount;
import hu.preznyak.hotel.cinnamon.service.DiscountManagementService;
import hu.preznyak.hotel.cinnamon.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {
    private final DiscountManagementService discountManagementService;
    private final DateUtils dateUtils;

    public DiscountController(DiscountManagementService discountManagementService, DateUtils dateUtils) {
        this.discountManagementService = discountManagementService;
        this.dateUtils = dateUtils;
    }

    @GetMapping
    public ResponseEntity<List<Discount>> getAllDiscount(){
        return new ResponseEntity<>(this.discountManagementService.getAllDiscount(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Discount> createDiscount(@RequestBody Discount discount) {
        return new ResponseEntity<>(this.discountManagementService.createDiscount(discount), HttpStatus.CREATED);
    }

    @GetMapping(path = "/start")
    public ResponseEntity<List<Discount>> findAllAfterStartPeriod(@RequestParam String startDate) {
        return new ResponseEntity<>(this.discountManagementService.findAllAfterStartDate(dateUtils.createDateFromDateString(startDate)), HttpStatus.OK);
    }

    @GetMapping(path = "/between")
    public ResponseEntity<List<Discount>> findByStartOfSalePeriodBeforeAndEndOfSalePeriodAfter(@RequestParam String startDate, @RequestParam String endDate) {
        return new ResponseEntity<>(this.discountManagementService.findByStartOfSalePeriodBeforeAndEndOfSalePeriodAfter(
                dateUtils.createDateFromDateString(startDate), dateUtils.createDateFromDateString(endDate)), HttpStatus.OK);
    }
}
