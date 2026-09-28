package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream {
    public static void main(String[] args) {
        Stream<Integer> integers = Stream.of(43,22,62,72);
        System.out.println(integers);

        long count = integers.count();
        System.out.println(count);

        List<String> empt = new ArrayList<>();
        List<String> list = List.of("one", "two", "three", "once", "online", "oneline");
        Stream<String> stream = list.stream();

//        Set<String> startwitho = stream.filter((value) -> {
        stream.filter((value) -> {
            return value.startsWith("o");
        }).map((value) -> {
            return value.toUpperCase();
        }).distinct()
                .limit(3)
                .skip(1)
//                .collect(Collectors.toSet());
        .forEach((val) -> {
            empt.add(val);
        });

//        System.out.println(startwitho);
        System.out.println("Empt collection is: "+empt);

//        Empty stream -> used when we need to return an empty stream instead of null
        Stream<Object> emptyStream = Stream.empty();
        System.out.println("Empty stream is: "+emptyStream);
        System.out.println(emptyStream.count());


        Stream<Integer> integerStream = Stream.of(32, 5, 38, 88, 84);
        Stream<Integer> integerStream1 = integerStream.filter((val) -> val > 40);
        List<Integer> collect = integerStream1.collect(Collectors.toList());
        System.out.println("Collected list is : "+collect);



    }
}