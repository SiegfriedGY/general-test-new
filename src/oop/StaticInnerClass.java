package oop;

import java.util.*;

public class StaticInnerClass {

    static class Inner {
        private String name;

        private Inner(String name) {
            this.name = name;
        }

        private void add(){
            System.out.println("操作之前：" + this);
            name += "去你妹";
            System.out.println("操作之后：" + this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Inner inner = (Inner) o;
            return Objects.equals(name, inner.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        Inner inner1 = new Inner("aaa");
        Inner inner2 = new Inner("bbb");
        Inner inner3 = new Inner("ccc");

        Map<Inner, Integer> map = new HashMap<>();
        map.put(inner1,1);
        map.put(inner2,2);
        map.put(inner3,3);

        System.out.println(map);
        Set<Inner> inners = map.keySet();
        for (Inner inner : inners) {
            inner.add();// 一旦操作对象属性，则对象地址值就变了。
        }
        System.out.println(map);

        for (Map.Entry<Inner, Integer> entry: map.entrySet()) {
            System.out.println(entry.getValue() + "---");
        }
    }


}
