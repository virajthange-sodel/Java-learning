package streams;

import java.util.List;
import java.util.stream.IntStream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        List<Integer> integers = List.of(32, 44, 64, 90, 87, 69);
        int sum = integers.stream().mapToInt((n) -> n).sum();
        System.out.println("Sum of elements is: "+ sum);


        IntStream distinctElements = integers.stream().mapToInt((n) -> n).distinct();
//        System.out.println("The distinct elements are : "+ distinctElements);
//        IntStream.range(2,5).forEach((val) -> System.out.println(val));


        distinctElements.forEach((val) -> System.out.println(val));
    }
}
