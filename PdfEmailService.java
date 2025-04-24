@Service
public class PdfEmailService {
    @Autowired private JavaMailSender mailSender;
    @Autowired private PdfGeneratorUtil pdfUtil;

    public void sendBookingPdf(Booking booking, List<BookingRule> rules) throws Exception {
        ByteArrayOutputStream pdfStream = pdfUtil.generatePdf(booking, rules);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(booking.getEmailId());
        helper.setSubject("Hotel Booking Details");
        helper.setText("Please find attached your booking details.");

        helper.addAttachment("booking.pdf", new ByteArrayResource(pdfStream.toByteArray()));
        mailSender.send(message);
    }
}
