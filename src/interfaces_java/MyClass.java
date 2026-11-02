package interfaces_java;

interface Bottle {
    void useCase();
}
class PlasticBottle implements Bottle {
    public void useCase() {
        System.out.println("Using plasticbottle...");
    }
}
class Water {
    Bottle bottle;
    Water(Bottle bottle) {
        this.bottle = bottle;
    }
}

public class MyClass {
    public static void main(String[] args) {
        Bottle bottle = new PlasticBottle();
        Water water = new Water(bottle);
        water.bottle.useCase();
    }
}

