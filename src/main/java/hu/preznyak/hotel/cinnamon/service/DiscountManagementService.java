package hu.preznyak.hotel.cinnamon.service;

import hu.preznyak.hotel.cinnamon.config.EmailSenderConfiguration;
import hu.preznyak.hotel.cinnamon.data.Discount;
import hu.preznyak.hotel.cinnamon.repo.DiscountRepository;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DiscountManagementService {
    private final DiscountRepository discountRepository;
    private final EmailSenderConfiguration emailSenderConfiguration;
    public final JobLauncher jobLauncher;

    public DiscountManagementService(DiscountRepository discountRepository, EmailSenderConfiguration emailSenderConfiguration, JobLauncher jobLauncher) {
        this.discountRepository = discountRepository;
        this.emailSenderConfiguration = emailSenderConfiguration;
        this.jobLauncher = jobLauncher;
    }

    public Discount createDiscount(Discount discount) {
        if(Objects.isNull(discount)){
            throw new UnsupportedOperationException("Discount cannot be null.");
        }
        try {
            JobParametersBuilder parametersBuilder = new JobParametersBuilder();
            this.jobLauncher.run(emailSenderConfiguration.sendEmailJob(), parametersBuilder.toJobParameters());
        } catch (JobInstanceAlreadyCompleteException | JobExecutionAlreadyRunningException |
                 JobParametersInvalidException | JobRestartException e) {
            throw new RuntimeException(e);
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
