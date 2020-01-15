package assembler;

import lombok.Getter;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

/**
 * @author Seunghyun Kim
 * @since 2020-01-16
 */
public class Assembler {
    @Getter
    private MemberDao memberDao;
    @Getter
    private MemberRegisterService regSvc;
    @Getter
    private ChangePasswordService pwdSvc;

    public Assembler() {
        memberDao = new MemberDao();
        regSvc = new MemberRegisterService(memberDao);
        pwdSvc = new ChangePasswordService(memberDao);
    }
}
