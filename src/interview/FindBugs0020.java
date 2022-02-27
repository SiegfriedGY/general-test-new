/*
 * Copyright (c) Numerical Method Inc.
 * http://www.numericalmethod.com/
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITH NO WARRANTY WHATSOEVER,
 * EITHER EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION,
 * ANY WARRANTIES OF ACCURACY, ACCESSIBILITY, COMPLETENESS,
 * FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, NON-INFRINGEMENT, 
 * TITLE AND USEFULNESS.
 * 
 * IN NO EVENT AND UNDER NO LEGAL THEORY,
 * WHETHER IN ACTION, CONTRACT, NEGLIGENCE, TORT, OR OTHERWISE,
 * SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR
 * ANY CLAIMS, DAMAGES OR OTHER LIABILITIES,
 * ARISING AS A RESULT OF USING OR OTHER DEALINGS IN THE SOFTWARE.
 */
package interview;

import java.util.*;
import org.joda.time.LocalDate;

/**
 * Identify, fix and explain the bug(s) in this code.
 *
 * This code initialize a map with today's information on past data.
 * Then the simulation advances the day by 1 day. It checks the sum of values in the map again.
 *
 * You need to have joda time to compile this code.
 *
 * @author Haksun Li
 */
public class FindBugs0020 {

    private static class MyDate {

        private LocalDate date;

        private MyDate(LocalDate today) {
            date = today;
        }

        private void inc() {
            date = date.plusDays(1);
        }

        // 要往 HashMap 里存储的对象，一般要重写 hashCode和equals方法，实现特有的判断对象相等逻辑。
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyDate myDate = (MyDate) o;
            return Objects.equals(date, myDate.date);
        }

        @Override
        public int hashCode() {
            return Objects.hash(date);
        }

    }

    public static void main(String[] args) {

        Map<MyDate, Integer> map = new HashMap<MyDate, Integer>();

        MyDate today = new MyDate(new LocalDate());
        map.put(today, 1);

        MyDate yesterday = new MyDate(today.date.plusDays(-1));
        map.put(yesterday, 2);

        MyDate dayBeforeYesterday = new MyDate(yesterday.date.plusDays(-1));
        map.put(dayBeforeYesterday, 3);

        System.out.println(map);
        // now simulation advances the day by 1
        Set<MyDate> dates = map.keySet();
        for (MyDate d : dates) {
            d.inc();
        }
        // 此处先后两次打印对象，可以看到三个对象的地址值已发生变化。
        System.out.println(map);

        /**
         * 因为该对象类型使用 LocalDate 属性作为重写 hashCode和 equals方法的依据，
         * 而上面的操作又修改了这个属性，会导致对象的地址值发生变化，即每个对象都变为另一个对象，
         * 因此底下用today, yesterday, dayBeforeYesterday三个引用去取的时候会得到null,导致程序出现空指针异常。
         * 改为遍历map的方法取值即可。
         */
        int sum = 0;

//        sum += map.get(today);
//        sum += map.get(yesterday);
//        sum += map.get(dayBeforeYesterday);

        for (Map.Entry<MyDate, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
        }

        System.out.println(sum);
    }
}
