@Service
public class BookingService {
    @Autowired private BookingRepository bookingRepository;
    @Autowired private BookingRuleRepository ruleRepository;

    public Booking getBookingByCustomer(String customerName) {
        return bookingRepository.findByCustomerName(customerName)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public List<BookingRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
