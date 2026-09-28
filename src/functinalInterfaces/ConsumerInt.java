package functinalInterfaces;

import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerInt {
    public static void main(String[] args) {
        Consumer<Integer> consumer = new Consumer<Integer> () {
            @Override
            public void accept(Integer value) {
                System.out.println("The values is : "+value);
            }
        };

        Consumer<Integer> consumer1= (value) -> System.out.println(value);

        consumer.accept(45);
        consumer1.accept(33);


        List<String> list = List.of("Pen", "Pencil", "Eraser");

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("The string value is: " +s);
            }
        });

        list.forEach((item) -> System.out.println("With lambda: "+ item) );


//      ==============  BiConsumer  ==============
        BiConsumer<Integer, String> biConsumer = new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer intvalue , String stringvalue) {
                System.out.println("Intvalues is : "+ intvalue+ " & string value is : "+ stringvalue);
            }
        };
        biConsumer.accept(2, "Akash");

        Map<String , Integer> map = Map.of("One", 1, "Two", 2);
        System.out.println(map);
        map.forEach(new BiConsumer<String, Integer> () {
            public void accept(String s, Integer i) {
                System.out.println(s + " "+ i);
            }
        });


//      ==============  Chaining with Consumer ==============
//        Here, the generic type of both the consumer don't have to be identical — but they do have to be compatible, and the direction of compatibility is fixed by andThen's signature.
        Consumer<String> cons1 = (val) -> System.out.println("From cons 1: "+ val);
//        Consumer<String> cons2 = (val) -> System.out.println("From cons 2: "+ val);
        Consumer<Object> cons2 = (val) -> System.out.println("From cons 2: "+ val);

        Consumer<String> stringConsumer = cons1.andThen(cons2);
        stringConsumer.accept("Bottle");


    }
}
