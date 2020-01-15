import lombok.Setter;

/**
 * @author Seunghyun Kim
 * @since 2020-01-15
 */

public class Greeter {

    @Setter
    private String format;

    String greet(String guest) {
        return String.format(format, guest);
    }
}
