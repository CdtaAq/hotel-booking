@Entity
public class Booking {
    @Id @GeneratedValue
    private Long id;
    private LocalDate bookingDate;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String hotelName;
    private String pathHotelPic;
    private String customerName;
    private String emailId;
    private String mobile;

    // Getters and setters
}
