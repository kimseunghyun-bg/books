package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Seunghyun Kim
 * @since 2020-04-01
 */

public class CacheAspect {

    private Map<Long, Object> cache = new HashMap<>();

    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long num = (long) joinPoint.getArgs()[0];
        if (cache.containsKey(num)) {
            System.out.printf("CacheAspect: Cache에서 구함[%d]\n", num);
            return cache.get(num);
        }

        Object result = joinPoint.proceed();
        cache.put(num, result);
        System.out.printf("CacheAspect: Cache에 추가[%d]\n", num);
        return result;
    }
}
