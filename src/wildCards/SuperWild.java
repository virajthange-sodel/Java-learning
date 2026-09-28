package wildCards;

import java.util.ArrayList;
import java.util.List;

public class SuperWild {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(List.of(3,21,63,77,73,90));         //Read only  -> List<Integer> cannot be a List<Number> because a List<Number> allows you to insert any Number, while a List<Integer> can only contain Integers.
        List<? extends Number> numbers = arrayList;
        System.out.println(numbers.get(0));
//        numbers.add(44);             //Not allowed

    }
}
