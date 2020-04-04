package controller;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Seunghyun Kim
 * @since 2020-04-04
 */
public class ChangePwdCommand {

    @Getter
    @Setter
    private String currentPassword;
    @Getter
    @Setter
    private String newPassword;
}
