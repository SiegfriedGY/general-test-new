package others;

import oop.Student;

import javax.swing.text.html.Option;
import java.util.Optional;

public class TestOptional {
    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.empty();
        System.out.println(stringOptional.isPresent());

        Optional<Integer> integerOptional = Optional.of(99);
        System.out.println(integerOptional.get());
        integerOptional = Optional.empty();
        System.out.println(integerOptional.orElse(199));
    }
}
