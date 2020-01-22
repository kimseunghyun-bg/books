package spring;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Seunghyun Kim
 * @since 2020-01-19
 */
public class MemberInfoPrinter {

    @Setter
    @Autowired
    private MemberDao memberDao;
    @Setter
    @Autowired
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