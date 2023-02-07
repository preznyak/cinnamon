package hu.preznyak.hotel.cinnamon.config;

import hu.preznyak.hotel.cinnamon.data.Guest;
import hu.preznyak.hotel.cinnamon.mapper.GuestRowMapper;
import hu.preznyak.hotel.cinnamon.processor.GuestItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
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
public class EmailSenderConfiguration {

    private static final String GUEST_SQL = "select GUEST_ID, " +
            "LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, " +
            "ADDRESS, STATE, PHONE_NUMBER, GENDER from GUEST order by GUEST_ID";
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Autowired
    public DataSource dataSource;

    @Bean
    public Job sendEmailJob() {
        return this.jobBuilderFactory.get("sendEmailJob")
                .incrementer(new RunIdIncrementer())
                .start(composeEmailStep()).build();
    }

    @Bean
    public GuestItemProcessor processor() {
        return new GuestItemProcessor();
    }

    @Bean
    public Step composeEmailStep() {
        return this.stepBuilderFactory.get("composeEmailStep")
                .<Guest, Guest>chunk(5)
                .reader(itemReader())
                .processor(processor())
                .writer(list -> list.forEach(guest -> {
                    System.out.println();
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
