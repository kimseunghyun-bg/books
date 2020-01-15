package spring;

/**
 * @author Seunghyun Kim
 * @since 2020-01-15
 */
public class AlreadyExistingMemberException extends RuntimeException {

    public AlreadyExistingMemberException(String message) {
        super(message);
    }
}
