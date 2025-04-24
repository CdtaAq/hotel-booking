@Component
public class PdfGeneratorUtil {

    public ByteArrayOutputStream generatePdf(Booking booking, List<BookingRule> rules) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        document.add(new Paragraph("Customer Name: " + booking.getCustomerName()));
        document.add(new Paragraph("Check-In Date: " + booking.getCheckInDate()));
        document.add(new Paragraph("Check-Out Date: " + booking.getCheckOutDate()));
        document.add(new Paragraph("Hotel Name: " + booking.getHotelName()));

        Image img = Image.getInstance(booking.getPathHotelPic());
        img.scaleToFit(300, 200);
        document.add(img);

        document.add(new Paragraph("Hotel Rules"));
        PdfPTable table = new PdfPTable(2);
        table.addCell("Rule Name");
        table.addCell("Description");

        for (BookingRule rule : rules) {
            table.addCell(rule.getRuleName());
            table.addCell(rule.getRuleDescription());
        }

        document.add(table);
        document.close();
        return out;
    }
}
