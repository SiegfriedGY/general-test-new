package java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author Siegfried GENG
 * @date 2019/8/5 - 15:18
 */
public class TestNewDate {

    /// 以前的Date类存在线程安全问题
    /// Java8的日期类是不可变的，因此也是线程安全的
    /// 都在java.time包

    public static void main(String[] args) {
        /// 获取实例，用静态方法！
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        Instant start = Instant.now();  /// 不是系统时间，而是零时区的时间。
        System.out.println(start);

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration);
    }

}
