package functinalInterfaces;

import java.util.function.Supplier;

class User {
    String name;
    Integer age;
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "{ "+  this.name + ", "+ this.age+ " }";
    }
}
public class SupplierInt {
    public static void main(String[] args) {
//        Supplier<Integer> intval = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                return 32;
//            }
//        };

        Supplier<Double> intval = () -> {
            return Math.random() * 100;
        };
        System.out.println(Math.floor(intval.get()));

        Supplier<User> getUser = () -> {
            return new User("Akash", 23);
        };
        System.out.println(getUser.get());
    }
}
