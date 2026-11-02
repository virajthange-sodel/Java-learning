package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

        Stream<Integer> integerStream2 = Stream.of(89, 43, 67, 34, 21);
        List<Integer> set1 = integerStream2.map((val) -> {
            return val + 1;
        }).collect(Collectors.toList());
        System.out.println("List after map is : "+set1);


        List<Integer> dummylist = List.of(32, 56, 32, 78, 90, 56);
        List<Integer> distinct_elements = dummylist.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct_elements);

        List<Integer> sortedlist = dummylist.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedlist);

        List<Integer> limitedList = dummylist.stream().limit(2).collect(Collectors.toList());
        System.out.println(limitedList);

        List<Integer> skippedList = dummylist.stream().skip(3).collect(Collectors.toList());
        System.out.println(skippedList);


//        takewhile() -> Keep taking elements as long as the condition is true. The moment it becomes false, STOP.
        List<Integer> trueCond = dummylist.stream()
//                .sorted()
                .takeWhile((val) -> val < 70).collect(Collectors.toList());
        System.out.println("truecond is: " + trueCond);

//        dorpwhile() -> Keep dropping elements from the beginning while the condition is true. Once it becomes false, stop dropping and keep everything from that point onward.
        List<Integer> droppedList = dummylist.stream().dropWhile((val) -> val > 40).collect(Collectors.toList());
        System.out.println(droppedList);


        List<Integer> list1 = dummylist.stream().filter((value) -> value > 50).toList();
        System.out.println("DummyToList is :  "+list1);

        Optional<Integer> firstElement = dummylist.stream().findFirst();
        System.out.println("The first element is: " + firstElement.get());

        Integer any = dummylist.stream().filter((value) -> value > 40).findAny().orElseThrow();
        System.out.println("Any element is: " + any);

        boolean greaterThan40 = dummylist.stream().anyMatch((value) -> value > 40);
        System.out.println("Is there any element greater than 40: " + greaterThan40);

        boolean allMatch = dummylist.stream().allMatch((value) -> value > 20);
        System.out.println("Are all matching : "+ allMatch);

        boolean noneMatch = dummylist.stream().noneMatch((value) -> value < 50);
        System.out.println(noneMatch);

    }
}

//Method	Purpose	Example
//filter()	Select elements	.filter(x -> x > 10)
//map()	Transform elements	.map(String::toUpperCase)
//flatMap()	Flatten nested streams	.flatMap(List::stream)
//distinct()	Remove duplicates	.distinct()
//sorted()	Sort elements	.sorted()
//peek()	Observe elements	.peek(System.out::println)
//limit()	Take first N	.limit(5)
//skip()	Skip first N	.skip(5)
//takeWhile()	Take while condition true	.takeWhile(x -> x < 10)
//dropWhile()	Drop while condition true	.dropWhile(x -> x < 10)





//INTERMEDIATE
//────────────────────────
//filter()
//map()
//flatMap()
//distinct()
//sorted()
//peek()
//limit()
//skip()
//takeWhile()
//dropWhile()
//mapToInt()
//mapToLong()
//mapToDouble()


//TERMINAL
//────────────────────────
//forEach()
//forEachOrdered()
//collect()
//toList()
//toArray()
//reduce()
//count()
//min()
//max()
//findFirst()
//findAny()
//anyMatch()
//allMatch()
//noneMatch()
//iterator()
//spliterator()