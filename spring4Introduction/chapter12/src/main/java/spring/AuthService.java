package spring;

import lombok.Setter;

/**
 * @author Seunghyun Kim
 * @since 2020-04-04
 */
public class AuthService {

    @Setter
    private MemberDao memberDao;

    public AuthInfo authenticate(String email, String password) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            throw new IdPasswordNotMatchingException();
        }
        if (!member.matchPassword(password)) {
            throw new IdPasswordNotMatchingException();
        }
        return new AuthInfo(member.getId(), member.getEmail(), member.getName());
    }
}
