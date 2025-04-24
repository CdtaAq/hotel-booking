@Entity
public class BookingRule {
    @Id @GeneratedValue
    private Long id;
    private String ruleName;
    private String ruleDescription;

    // Getters and setters
}
