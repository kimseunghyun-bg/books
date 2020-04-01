package chap07;

/**
 * @author Seunghyun Kim
 * @since 2020-03-30
 */
public class RecCalculator implements Calculator {
    @Override
    public long factorial(long num) {
        if (num == 0) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
}
