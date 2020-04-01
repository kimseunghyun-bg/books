package main;

import chap07.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Seunghyun Kim
 * @since 2020-04-01
 */
public class MainXmlAspect {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopAspect.xml");

        Calculator impCal = ctx.getBean("impeCal", Calculator.class);
        long fiveFact1 = impCal.factorial(5);
        System.out.println("impeCal.factorial(5) = " + fiveFact1);

        Calculator recCal = ctx.getBean("recCal", Calculator.class);
        long fiveFact2 = recCal.factorial(5);
        System.out.println("recCal.factorial(5) = " + fiveFact2);
    }
}
