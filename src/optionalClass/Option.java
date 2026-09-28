package optionalClass;

import org.w3c.dom.ls.LSOutput;

import java.util.Optional;

public class Option {
    public static void main(String[] args) {
//        Optional.of()
//        Optional<String> name = Optional.of(null);   //NullPointerException
        Optional<String> name = Optional.of("Raj");   //NullPointerException
        System.out.println(name);
        System.out.println(name.get());

//        ===========  Optional.ofNullable()  ===========

//        Optional<String> atish = Optional.ofNullable(null);
//        System.out.println(atish);             //Optional.empty
//        System.out.println(atish.get());      //NullPointerException

        Optional<String> atish = Optional.ofNullable("Atish");
        System.out.println(atish);             //Optional[Atish]
        System.out.println(atish.get());      //Atish

//        if(atish.isPresent()) {
//            System.out.println("Atish is present");
//        }
        atish.ifPresent(System.out::println);    //Atish
        atish.ifPresent((value) -> {
            System.out.println("Consumer working");
            System.out.println(value);
        });

        atish.ifPresentOrElse((value) -> {
            System.out.println("Tha value is present: " + value);
        },() -> {
            System.out.println("The value is not present");
        });

//        public void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction) {
//            if (value != null) {
//                action.accept(value);
//            } else {
//                emptyAction.run();
//            }
//        }

        Optional<String> atishmap = atish.map((value) -> atish.get());         //if atish.get() is empty -> it gives us Optional.empty not any exception
        System.out.println("Atish map "+ atishmap );

        if(atish.isEmpty()) {
            System.out.println("Atish is empty");
        }

        Optional<Integer> age = Optional.ofNullable(25);
        Optional<Integer> validAge = age.filter((val) -> val > 18);     //It returns optional[age] if satisfy the specified condition, otherwise Optinal.empty
        System.out.println(validAge);


//        Optional<String> obj = Optional.ofNullable("tiger");
//        Optional<String> obj = Optional.ofNullable(null);
//
//        String unknown = obj.orElse("Unknown");        // -> Can provide default value if the value is not present
//        System.out.println(unknown);
//
//        String unknown2 =  obj.orElseGet(() -> "Only if");
//        System.out.println(unknown2);
////        orElse() → default is evaluated immediately
////        orElseGet() → default is evaluated only if needed
//
//        String s = obj.orElseThrow(() -> {
//            throw new RuntimeException("Value is not present");
//        });




//        ===========  Optional.empty()  ===========
        Optional<Object> empty = Optional.empty();
//        System.out.println(empty);              //Optional.empty
//        Object o = empty.get();              //NoSuchElementException
//        System.out.println(o);


        String str = "Hello";
        Optional<Object> result =
                Optional.empty()
                        .or(() -> Optional.of(str));
        System.out.println(result);

//        Optional<Object> or = Optional.ofNullable(null).or(() -> Optional.of("Water"));
        Optional<String> or = Optional.ofNullable("Bottle").or(() -> Optional.of("Water"));
        System.out.println(or);

        Optional<Integer> i1 = Optional.of(33);
        Optional<Integer> i = i1.map((value) -> value * 2);
        i.ifPresent((val) -> System.out.println(val));
        i.ifPresent(System.out::println);

    }
}