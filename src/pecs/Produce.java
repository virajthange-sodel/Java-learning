package pecs;

import java.util.ArrayList;
import java.util.List;

public class Produce {
    public static void main(String[] args) {
        List<? extends Number> numberList = List.of(4.3,25,73,88);      //numbers can be a List<Integer>, List<Double>, List<Float>, etc.
        System.out.println(numberList);
        System.out.println(numberList.get(0));     //You can read from it

//        numberList.add(40);   // But you can't safely add ,Because Java doesn't know whether the actual list is List<Integer>, List<Double>, List<Float>

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(43.20);
        doubleList.add(89.2);
        doubleList.add(90.22);
//        List<? super Integer> numbers  = doubleList;
//        List<? super Integer> numbers  = List.of(4.3,32,7,4,2);

        List<? super Integer> numbers  = List.of(doubleList);

        System.out.println(numbers);

        Number number = 4.4;
        System.out.println(number instanceof Double);
    }
}
