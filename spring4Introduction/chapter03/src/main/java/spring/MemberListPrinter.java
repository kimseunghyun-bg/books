package spring;

import java.util.Collection;

/**
 * @author Seunghyun Kim
 * @since 2020-01-19
 */
public class MemberListPrinter {

    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
        this.memberDao = memberDao;
        this.memberPrinter = memberPrinter;
    }

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        for (Member member : members) {
            memberPrinter.print(member);
        }
    }
}
