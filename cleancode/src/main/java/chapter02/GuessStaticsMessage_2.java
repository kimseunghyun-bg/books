package chapter02;

/**
 * @author Seunghyun Kim
 * @since 2019-11-20
 */
public class GuessStaticsMessage_2 {
    private String number;
    private String verb;
    private String pluralModifier;

    public String make(char candidate, int count) {
        return String.format(
                "There %s %s %s%s",
                verb, number, candidate, pluralModifier);
    }

    private void createPluralDependentMessageParts(int count) {
        if (count == 0) {
            thereAreNoLetters();
        } else if (count == 1) {
            thereIsOneLetter();
        } else {
            thereAreManyLetters(count);
        }
    }

    private void thereAreManyLetters(int count) {
        number = Integer.toString(count);
        verb = "are";
        pluralModifier = "s";
    }

    private void thereIsOneLetter() {
        number = "1";
        verb = "is";
        pluralModifier = "";
    }

    private void thereAreNoLetters() {
        number = "no";
        verb = "are";
        pluralModifier = "s";
    }

}
