import annotations.MyAnnotation;

public class Custom {

    @MyAnnotation(value = "hello", age = 33)
    public static int dummyMethod()  {
        return 45;
    }
}
