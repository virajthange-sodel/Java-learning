package functinalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class FuctionInt {
    public static void main(String[] args) {
//        Function<String, Integer> function = new Function<String, Integer> () {
//            public Integer apply(String inp) {
//                return inp.length();
//            }
//        };

        Function<String, Integer> function = val -> val.length();

//        Function<String, Integer> function = String::length;

        Integer len = function.apply("Sanket");
        System.out.println(len);

//        System.out.println(transform(List.of("Akash", "Sanket", "Vipul"), new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return s.length();
//            }
//        }));
//        System.out.println(transform(List.of("Akash", "Sanket", "Vipul"), s -> s.length()));

        System.out.println(transform(List.of("Akash", "Sanket", "Vipul"), String::length));

    }

    public static List<Integer> transform(List<String> list, Function<String, Integer> mapper) {
        List<Integer> numbers = new ArrayList<>();
        for(String val : list) {
            Integer res = mapper.apply(val);
            numbers.add(res);
        }
        return numbers;
    }
}