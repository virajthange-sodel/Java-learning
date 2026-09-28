package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PredAndFun {
    public static void main(String[] args) {
        Function<List<Integer>, List<Integer>> function = list -> {
            list.add(45);
            return list;
        };

        List<Integer> apply = function.apply(new ArrayList<>());
        System.out.println(apply);


//        apply.stream().filter()

    }
}
