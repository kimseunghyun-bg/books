package spring;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Seunghyun Kim
 * @since 2020-04-01
 */

public class Member {

    public Member(String email, String password, String name, Date registerDate) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.registerDate = registerDate;
    }

    @Getter
    @Setter
    private Long id;
    @Getter
    private String email;
    @Getter
    private String password;
    @Getter
    private String name;
    @Getter
    private Date registerDate;

    public void changePassword(String oldPassword, String newPassword) {
        if (!password.equals(oldPassword)) {
            throw new IdPasswordNotMatchingException();
        }
        this.password = newPassword;
    }
}
