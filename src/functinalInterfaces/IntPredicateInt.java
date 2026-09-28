package functinalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Why it exists instead of just Predicate<Integer>
//Predicate<Integer> would force autoboxing — every int you test gets wrapped into an Integer object first. IntPredicate works directly on primitive int, so no boxing happens:

public class IntPredicateInt {
    public static void main(String[] args) {
        IntPredicate intPredicate = (val) -> {
            return val > 30;
        };
        IntPredicate negate = intPredicate.negate();

//        Performing same operation on two predicates
        boolean test = intPredicate.test(40);
        System.out.println(test);
        boolean test2 = negate.test(40);
        System.out.println(test2);

//        Check with two conditions
        IntPredicate condition1 = (val) -> val > 20;
        IntPredicate condition2 = (val) -> val % 2 == 0;

        IntPredicate combinePredicate = condition1.and(condition2);
        boolean test1 = combinePredicate.test(40);
        System.out.println("Is it following both the conditions ? : "+test1);

        IntStream intStream = IntStream.of(43, 2, 90, 66, 73, 45);
        long collect = intStream.filter((value -> value > 20)).count();
        System.out.println("The count of the elements is: "+collect);
    }
}