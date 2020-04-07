package controller;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Seunghyun Kim
 * @since 2020-04-04
 */
public class LoginCommand {

    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;
    @Setter
    private boolean rememberEmail;

    public boolean isRememberEmail() {
        return rememberEmail;
    }
}
