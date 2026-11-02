package terms;

import java.lang.reflect.Field;
import java.sql.Array;
import java.util.Arrays;

class Bike {
    String color;
    String model;

    public Bike(String color, String model) {
        this.color = color;
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

public class FieldObj {


    public static void main(String[] args) throws IllegalAccessException {
        Bike bike = new Bike("Black", "Hunter 350");
        System.out.println(bike.getClass());
        System.out.println(bike.getClass().accessFlags());
        System.out.println(bike.getClass().getDeclaredFields());

        for (Field field : bike.getClass().getDeclaredFields()) {
            System.out.println(field);
            System.out.println("Value of bike field is: " + field.get(bike));
        }

        System.out.println(Arrays.hashCode(new int[] {32,57,32,90,81}));



    }
}
