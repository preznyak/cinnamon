package hu.preznyak.hotel.cinnamon.service;

import hu.preznyak.hotel.cinnamon.data.Guest;
import hu.preznyak.hotel.cinnamon.repo.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GuestManagementService {
    private final GuestRepository guestRepository;

    public GuestManagementService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> findAllGuest(){
        List<Guest> guestList = new ArrayList<>();
        Iterable<Guest> guests = this.guestRepository.findAll();
        guests.forEach(guestList::add);
        guestList.sort(Comparator.comparing(Guest::getFirstName));
        return guestList;
    }

    public void deleteGuest(Long guestId){
        this.guestRepository.findById(guestId)
                .orElseThrow(() -> new NoSuchElementException("No guest found with the given ID."));
        this.guestRepository.deleteById(guestId);
    }

    public Guest addGuest(Guest guest){
        if (Objects.isNull(guest)) {
            throw new UnsupportedOperationException("Guest cannot be null.");
        }
        return this.guestRepository.save(guest);
    }

    public Guest updateGuest(Guest guest){
        if (Objects.isNull(guest)) {
            throw new UnsupportedOperationException("Guest cannot be null.");
        }
        Guest savedGuest = this.guestRepository.findById(guest.getId())
                .orElseThrow(() -> new NoSuchElementException("No guest found with the given ID."));
        savedGuest.setPhoneNumber(guest.getPhoneNumber());
        savedGuest.setEmailAddress(guest.getEmailAddress());
        savedGuest.setCountry(guest.getCountry());
        savedGuest.setAddress(guest.getAddress());
        savedGuest.setState(guest.getState());
        return this.guestRepository.save(savedGuest);

    }
}
