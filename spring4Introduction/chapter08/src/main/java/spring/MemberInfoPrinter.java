package spring;

import lombok.Setter;

/**
 * @author Seunghyun Kim
 * @since 2020-04-01
 */
public class MemberInfoPrinter {

    @Setter
    private MemberDao memberDao;
    @Setter
    private MemberPrinter printer;

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            System.out.println("데이터 없음\n");
            return;
        }
        printer.print(member);
        System.out.println();
    }
}