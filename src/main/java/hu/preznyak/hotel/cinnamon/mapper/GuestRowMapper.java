package hu.preznyak.hotel.cinnamon.mapper;

import hu.preznyak.hotel.cinnamon.data.Gender;
import hu.preznyak.hotel.cinnamon.data.Guest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestRowMapper implements RowMapper<Guest> {
    @Override
    public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
        Guest guest = new Guest();
        guest.setId(rs.getInt("guest_id"));
        guest.setFirstName(rs.getString("first_name"));
        guest.setLastName(rs.getString("last_name"));
        guest.setPhoneNumber(rs.getString("phone_number"));
        guest.setAddress(rs.getString("address"));
        guest.setState(rs.getString("state"));
        guest.setCountry(rs.getString("country"));
        guest.setEmailAddress(rs.getString("email_address"));
        guest.setGender(Gender.fromValue(rs.getString("gender")));
        return guest;
    }
}
