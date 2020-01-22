package spring;

import java.util.Date;

/**
 * @author Seunghyun Kim
 * @since 2020-01-15
 */
public class MemberRegisterService {
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void register(RegisterRequest request) {
        Member member = memberDao.selectByEmail(request.getEmail());
        if (member != null) {
            throw new AlreadyExistingMemberException("duplicated email " + request.getEmail());
        }
        Member newMember = new Member(
                request.getEmail(), request.getPassword(),
                request.getName(), new Date()
        );
        memberDao.insert(newMember);
    }
}
