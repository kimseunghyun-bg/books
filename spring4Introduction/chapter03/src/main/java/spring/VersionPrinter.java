package spring;

import lombok.Setter;

/**
 * @author Seunghyun Kim
 * @since 2020-01-19
 */
public class VersionPrinter {

    @Setter
    private int majorVersion;
    @Setter
    private int minorVersion;

    public void print() {
        System.out.printf("이 프로그램의 버전은 %d.%d입니다.\n\n", majorVersion, minorVersion);
    }

}
