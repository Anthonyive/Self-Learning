package capers;

import java.io.*;

import static capers.Utils.join;

/**
 * Represents a dog that can be serialized.
 *
 * @author Yuchen Zhang
 */
public class Dog implements Serializable {

    /**
     * Folder that dogs live in.
     */
    static final File CWD = new File(System.getProperty("user.dir"));
    static final File CAPERS_FOLDER = join(CWD, "capers");
    static final File DOG_FOLDER = join(CAPERS_FOLDER, "dogs");

    /**
     * Age of dog.
     */
    private int age;
    /**
     * Breed of dog.
     */
    private String breed;
    /**
     * Name of dog.
     */
    private String name;

    /**
     * Creates a dog object with the specified parameters.
     *
     * @param name  Name of dog
     * @param breed Breed of dog
     * @param age   Age of dog
     */
    public Dog(String name, String breed, int age) {
        this.age = age;
        this.breed = breed;
        this.name = name;
    }

    /**
     * Reads in and deserializes a dog from a file with name NAME in DOG_FOLDER.
     *
     * @param name Name of dog to load
     * @return Dog read from file
     */
    public static Dog fromFile(String name) {
        File dogFile = join(DOG_FOLDER, name);
        Dog dog;
        try {
            ObjectInputStream inp = new ObjectInputStream(new FileInputStream(dogFile));
            dog = (Dog) inp.readObject();
            inp.close();
        } catch (IOException | ClassNotFoundException excp) {
            dog = null;
        }
        return dog;
    }

    /**
     * Increases a dog's age and celebrates!
     */
    public void haveBirthday() {
        age += 1;
        System.out.println(toString());
        System.out.println("Happy birthday! Woof! Woof!");
    }

    /**
     * Saves a dog to a file for future use.
     */
    public void saveDog() {
        // assumes dog names are unique
        File dogFile = join(DOG_FOLDER, this.name);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dogFile));
            out.writeObject(this);
            out.close();
        } catch (IOException excp) {
            System.out.print("Failed to save the serializable object.");
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Woof! My name is %s and I am a %s! I am %d years old! Woof!",
                name, breed, age);
    }

}
