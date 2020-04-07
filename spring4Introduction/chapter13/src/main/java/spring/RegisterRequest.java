package spring;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Seunghyun Kim
 * @since 2020-04-01
 */
public class RegisterRequest {

    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String confirmPassword;
    @Getter
    @Setter
    private String name;

    public boolean isPasswordEqualToConfirmPassword() {
        return password.equals(confirmPassword);
    }
}
