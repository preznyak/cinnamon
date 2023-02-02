package hu.preznyak.hotel.cinnamon.config;

import hu.preznyak.hotel.cinnamon.data.Guest;
import hu.preznyak.hotel.cinnamon.mapper.GuestRowMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchConfiguration {

    private static final String GUEST_SQL = "select GUEST_ID, " +
            "LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, " +
            "ADDRESS, STATE, PHONE_NUMBER from GUEST order by GUEST_ID";
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Autowired
    public DataSource dataSource;

    @Bean
    public Job sendEmailJob() {
        return this.jobBuilderFactory.get("sendEmailJob")
                .start(composeEmailStep()).build();
    }

    @Bean
    public Step composeEmailStep() {
        return this.stepBuilderFactory.get("composeEmailStep")
                .<Guest, Guest>chunk(5)
                .reader(itemReader())
                .writer(list -> list.forEach(guest -> {
                    System.out.println(String.format("Sending email to %s with the content:" +
                            "We are happy to inform you, that a new sale period started at Hotel Cinnamon!" +
                            "Plan your next visit to us between %s and %s and have a discount for your stay!" +
                            "See you soon!", guest.getEmailAddress(), "todo", "todo"));
                }))
                .build();
    }

//    @Bean
//    public ItemWriter<Guest> itemWriter() {
//        return new JsonFileItemWriterBuilder<Guest>()
//                .jsonObjectMarshaller(new JacksonJsonObjectMarshaller<>())
//                .resource(new FileSystemResource("email_sent_to.json"))
//                .name("jsonItemWriter")
//                .build();
//    }

    @Bean
    public ItemReader<Guest> itemReader() {

        return new JdbcCursorItemReaderBuilder<Guest>()
                .dataSource(dataSource)
                .name("jdbcCursorItemReader")
                .sql(GUEST_SQL)
                .rowMapper(new GuestRowMapper())
                .build();
    }
}
