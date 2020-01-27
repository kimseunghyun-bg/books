package main;

import org.springframework.context.support.GenericXmlApplicationContext;
import spring.Client;

/**
 * @author Seunghyun Kim
 * @since 2020-01-28
 */
public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:springconf.xml");
        Client client = ctx.getBean("client", Client.class);
        client.send();
        ctx.close();
    }
}
