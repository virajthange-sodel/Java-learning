package sealedClasses;

sealed class Key permits Key1, Key2{

}

non-sealed class Key1 extends Key {

}
final class Key2 extends Key {

}


public class Lock {
    public static void main(String[] args) {

    }
}
