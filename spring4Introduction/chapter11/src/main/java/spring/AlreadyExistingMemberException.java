package spring;

/**
 * @author Seunghyun Kim
 * @since 2020-04-01
 */
public class AlreadyExistingMemberException extends RuntimeException {

    public AlreadyExistingMemberException(String message) {
        super(message);
    }
}
