public class Dog {
    public static int weightInPounds;

    // One integer constructor for dogs.
    public Dog(int w) {
        weightInPounds = w;
    }

    public static void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("Yip!");
        } else if (weightInPounds < 30) {
            System.out.println("Bark!");
        } else {
            System.out.println("Wooof!");
        }
    }
}
