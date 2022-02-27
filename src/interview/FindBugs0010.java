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

/**
 * Identify, fix and explain the bug(s) in this code.
 *
 * This code find the intersection of two groups of object, and then sum them up.
 *
 * @author Haksun Li
 */
public class FindBugs0010 {

    public static class Item {

        private static int id = 0;
        public final double value;
        public final String name;

        public Item(double value) {
            this.value = value;
            this.name = String.format("item%d", ++id);
//            System.out.println(this.id + " === " + this.value + " === " +this.name);
        }

        // To get distinct elements in Set, equals and hashCode methods must be overridden.
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return Double.compare(item.value, value) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    public static void main(String[] args) {
        Random rng = new Random();
        rng.setSeed(1234567890L);

        // generate the sets
        Set<Item> set1 = new HashSet<Item>();
        Set<Item> set2 = new HashSet<Item>();
        for (int i = 0; i < 1000; ++i) {
            Item item = new Item(rng.nextDouble());
            set1.add(item);

            if (rng.nextInt() % 5 == 0) {
                set2.add(item);
            }
        }

        for (int i = 0; i < 500; ++i) {
            Item item = new Item(rng.nextDouble());
            set2.add(item);
        }

        // find intersection of set1 and set2
        double sum = intersectSum(set1, set2);
        System.out.println(sum);
    }

    // find intersection of set1 and set2
    private static double intersectSum(Collection<Item> set1, Collection<Item> set2) {
        // find intersect
        set1.retainAll(set2);

        // sum up the item values
        double sum = 0;
        for (Item item : set1) {
            sum += item.value;
        }

        return sum;
    }
}
