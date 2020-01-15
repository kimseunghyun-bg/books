import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Seunghyun Kim
 * @since 2020-01-15
 */

class GreeterTest {

    @Test
    void testGreet() {
        // given
        Greeter greeter = new Greeter();
        greeter.setFormat("%s, Hello!");
        // when
        String actual = greeter.greet("spring");
        // then
        assertThat(actual, is("spring, Hello!"));
    }
}