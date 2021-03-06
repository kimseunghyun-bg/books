package main;

import config.JavaMainConf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

/**
 * @author Seunghyun Kim
 * @since 2020-01-23
 */
public class MainXmlJava {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:main-conf.xml");
        MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
        MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);

        RegisterRequest regReq = new RegisterRequest();
        regReq.setEmail("madvirus@madvirus.net");
        regReq.setName("김승현");
        regReq.setPassword("1234");
        regReq.setConfirmPassword("1234");
        regSvc.register(regReq);

        infoPrinter.printMemberInfo("madvirus@madvirus.net");
    }
}
