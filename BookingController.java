@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired private BookingService bookingService;
    @Autowired private PdfEmailService emailService;

    @GetMapping("/pdf/{customerName}")
    public ResponseEntity<String> generateBookingPdf(@PathVariable String customerName) {
        try {
            Booking booking = bookingService.getBookingByCustomer(customerName);
            List<BookingRule> rules = bookingService.getAllRules();
            emailService.sendBookingPdf(booking, rules);
            return ResponseEntity.ok("Booking PDF sent to " + booking.getEmailId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error: " + e.getMessage());
        }
    }
}
