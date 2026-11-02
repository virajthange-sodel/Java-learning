package JavaOjbect;

import java.util.Optional;

class Student {
    private String name;
    private int age;

    public Student () {}
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}


public class CompareObj {
    
    
    public static void catchExc() {
        int val = 44;
        try {
            if(val < 45) throw new IndexOutOfBoundsException("Value is less than 45");
            if(val < 50) throw new ArithmeticException("Value is less than 50");
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Caught exception "+ e.getMessage());
            System.out.println(e.getClass().getName());
        }
        
    }
    
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(29);
        student.setName("Sanket");

        System.out.println(student.equals(student));

        Long l1 = 43l;
        Long l2 = 43l;
        System.out.println("Long values equality is: " + l1.equals(l2));
//        new S

        Optional<Integer> val = Optional.of(43);
//        val.map()
        catchExc();

    }
}
