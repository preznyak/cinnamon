package hu.preznyak.hotel.cinnamon.data;

public class EmailDetailsDto {
    private String guestFirstName;
    private String guestLastName;
    private String guestPreName;
    private String guestEmail;

    public EmailDetailsDto(String guestFirstName, String guestLastName, String guestPreName, String guestEmail) {
        this.guestFirstName = guestFirstName;
        this.guestLastName = guestLastName;
        this.guestPreName = guestPreName;
        this.guestEmail = guestEmail;
    }

    public String getGuestFirstName() {
        return guestFirstName;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    public String getGuestPreName() {
        return guestPreName;
    }

    public void setGuestPreName(String guestPreName) {
        this.guestPreName = guestPreName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    @Override
    public String toString() {
        return "EmailDetailsDto{" +
                "guestFirstName='" + guestFirstName + '\'' +
                ", guestLastName='" + guestLastName + '\'' +
                ", guestPreName='" + guestPreName + '\'' +
                ", guestEmail='" + guestEmail + '\'' +
                '}';
    }
}
