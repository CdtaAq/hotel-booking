public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByCustomerName(String name);
}
