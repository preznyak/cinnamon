package hu.preznyak.hotel.cinnamon.processor;

import hu.preznyak.hotel.cinnamon.data.EmailDetailsDto;
import hu.preznyak.hotel.cinnamon.data.Gender;
import hu.preznyak.hotel.cinnamon.data.Guest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class GuestItemProcessor implements ItemProcessor<Guest, Guest> {

    private static final Logger log = LoggerFactory.getLogger(GuestItemProcessor.class);
    @Override
    public Guest process(Guest guest) {

        if (guest.getFirstName().contains("Mr.") || guest.getFirstName().contains("Mrs.")) {
            return guest;
        }
        System.out.println("Gender of " + guest.getLastName() + " : " + guest.getGender());
        String preName = "";
        if (Gender.MALE.equals(guest.getGender())) {
            preName = "Mr. ";
        } else if (Gender.FEMALE.equals(guest.getGender())){
            preName = "Mrs. ";
        }
        guest.setFirstName(preName + guest.getFirstName());
        log.info("Converted -> " + guest.getFirstName() + ", " + guest.getLastName());

        return guest;
    }
}
