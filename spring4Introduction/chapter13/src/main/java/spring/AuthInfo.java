package spring;

import lombok.Getter;

/**
 * @author Seunghyun Kim
 * @since 2020-04-04
 */
public class AuthInfo {

    @Getter
    private Long id;
    @Getter
    private String email;
    @Getter
    private String name;

    public AuthInfo(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
}
