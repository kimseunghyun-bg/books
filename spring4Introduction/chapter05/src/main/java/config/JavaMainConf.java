package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;

/**
 * @author Seunghyun Kim
 * @since 2020-01-23
 */
@Configuration
@ImportResource("classpath:sub-conf.xml")
public class JavaMainConf {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegSvc(){
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

}
