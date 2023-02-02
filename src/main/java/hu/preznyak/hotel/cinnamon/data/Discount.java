package hu.preznyak.hotel.cinnamon.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DISCOUNT")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DISCOUNT_ID")
    private long id;
    @Column(name = "START_OF_SALE_PERIOD")
    private Date startOfSalePeriod;
    @Column(name = "END_OF_SALE_PERIOD")
    private Date endOfSalePeriod;
    @Column(name = "DISCOUNT_PERCENTAGE")
    private Integer discountPercentage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartOfSalePeriod() {
        return startOfSalePeriod;
    }

    public void setStartOfSalePeriod(Date startOfSalePeriod) {
        this.startOfSalePeriod = startOfSalePeriod;
    }

    public Date getEndOfSalePeriod() {
        return endOfSalePeriod;
    }

    public void setEndOfSalePeriod(Date endOfSalePeriod) {
        this.endOfSalePeriod = endOfSalePeriod;
    }

    public Integer getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Integer discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
