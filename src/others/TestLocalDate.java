package others;

import java.time.LocalDate;

public class TestLocalDate {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.toString());
        System.out.println(date.toString().equals("aa"));
        System.out.println(date.toString().equals("2021-10-15"));
    }
}
