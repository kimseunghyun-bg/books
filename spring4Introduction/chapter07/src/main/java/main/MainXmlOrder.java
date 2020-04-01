package main;

import chap07.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Seunghyun Kim
 * @since 2020-04-01
 */
public class MainXmlOrder {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopOrder.xml");

        Calculator impeCal = ctx.getBean("impeCal", Calculator.class);
        impeCal.factorial(5);
        impeCal.factorial(5);
    }
}
