package IOHandling.Stream;

import java.io.Serializable;

//
//Serializable interface :
// Serializable interface is present in java.io package.
// It is used to make an object eligible for saving its state into a file.
// This is called Serialization.
//Classes that do not implement this interface will not have any of their state serialized or deserialized.
// All subtypes of a serializable class are themselves serializable.
public class Student implements Serializable {
    int id;
    String name;
    boolean active;
    private final long serialVersionUID=1L;

    public Student(int i, String name, boolean b) {
        this.name = name;
        id = i;
        active = b;
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }

}
