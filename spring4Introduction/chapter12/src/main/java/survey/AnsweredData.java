package survey;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Seunghyun Kim
 * @since 2020-04-02
 */
public class AnsweredData {

    @Getter
    @Setter
    private List<String> responses;
    @Getter
    @Setter
    private Respondent res;
}
