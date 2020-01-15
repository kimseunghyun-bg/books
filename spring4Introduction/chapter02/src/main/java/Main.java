import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Seunghyun Kim
 * @since 2020-01-15
 */

public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
        Greeter greeter = context.getBean("greeter", Greeter.class);
        String message = greeter.greet("Spring");
        System.out.println(message);

        Greeter greeter1 = context.getBean("greeter", Greeter.class);
        Greeter greeter2 = context.getBean("greeter", Greeter.class);
        System.out.println("(greeter1 == greeter2) = " + (greeter1 == greeter2));

        context.close();
    }
}
