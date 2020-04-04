package survey;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

/**
 * @author Seunghyun Kim
 * @since 2020-04-02
 */
public class Question {

    @Getter
    private String title;
    @Getter
    private List<String> options;

    public Question(String title, List<String> options) {
        this.title = title;
        this.options = options;
    }

    public Question(String title) {
        this(title, Collections.<String>emptyList());
    }

    public boolean isChoice() {
        return options != null && !options.isEmpty();
    }
}
