package cf.mindaugas.sdademos.javaadvanced._14_io;

import java.io.*;

public class _01_Serialization {
    public static void main(String[] args) {
        // Serializing an object
        Person person = new Person("Michael", "Dudikoff");
        File f = new File("object_serialized.ser");

        // We can create several object in the try clause when using autoclosable interface
        // try (
        //         FileOutputStream fileOutputStream = new FileOutputStream(f);
        //         ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        //     ) {
        //     objectOutputStream.writeObject(person);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // Deserializing an object
        Person person2;
        try (
                FileInputStream fileInputStream = new FileInputStream(new File("object_serialized.ser"));
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
            ) {
            person2 = (Person) objectInputStream.readObject();
            System.out.println(person2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Person implements Serializable {
    // version id used to prevent deserialization of old objects when
    // then class has changed and is no longer compatible with those old objects
    private static final long serialversionUID = 129348938L;

    // transient field - will not be serialized
    transient int age;

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
