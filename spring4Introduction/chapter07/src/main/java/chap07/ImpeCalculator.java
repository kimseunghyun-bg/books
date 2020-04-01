package chap07;

/**
 * @author Seunghyun Kim
 * @since 2020-03-30
 */
public class ImpeCalculator implements Calculator {

    @Override
    public long factorial(long num) {
//        long start = System.currentTimeMillis();
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
//        long end = System.currentTimeMillis();
//        System.out.printf("spring.ImpeCalculator.factorial(%d) 실행시간 = %d\n", num, (end-start));
        return result;
    }
}
