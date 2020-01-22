package config;

import org.springframework.context.annotation.Bean;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;

/**
 * @author Seunghyun Kim
 * @since 2020-01-23
 */
public class JavaConfig3 {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegSvc(){
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public MemberPrinter printer() {
        return new MemberPrinter();
    }

    @Bean
    public MemberInfoPrinter infoPrinter(MemberDao memberDao, MemberPrinter printer) {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setMemberDao(memberDao);
        infoPrinter.setPrinter(printer);
        return infoPrinter;
    }
}
