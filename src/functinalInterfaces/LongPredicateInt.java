package functinalInterfaces;

import java.util.function.LongPredicate;

public class LongPredicateInt {
    public static void main(String[] args) {
        LongPredicate longPredicate = (value) -> {
            return value > 20 && value % 2 == 0;
        };

        boolean test = longPredicate.test(80);
        System.out.println("Test is : "+ test);
    }
}