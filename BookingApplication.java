@Bean
CommandLineRunner runner(BookingRepository bookingRepo, BookingRuleRepository ruleRepo) {
    return args -> {
        Booking booking = new Booking();
        booking.setCustomerName("John Doe");
        booking.setEmailId("john.doe@example.com");
        booking.setMobile("1234567890");
        booking.setHotelName("The Ocean View");
        booking.setPathHotelPic("hotel.jpg");
        booking.setBookingDate(LocalDate.now());
        booking.setCheckInDate(LocalDate.now().plusDays(2));
        booking.setCheckOutDate(LocalDate.now().plusDays(5));
        bookingRepo.save(booking);

        ruleRepo.saveAll(List.of(
            new BookingRule(null, "No Smoking", "Smoking is not allowed in the hotel."),
            new BookingRule(null, "Check-in Time", "Check-in starts at 2 PM."),
            new BookingRule(null, "Pets", "Pets are not allowed.")
        ));
    };
}
