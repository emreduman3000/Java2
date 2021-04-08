package requiredClasses;

interface C
{

}
public class A implements C {

    private String name;
    private int age;
    public static final String Afield="field";

    public A() {
    }

    public A(String name, int age) {
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
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    static public class memberClass{};
    public interface memberInterface{};

    static public void method()
    {
        class localClass{}
    }

    enum Color
    {
        RED, GREEN, BLUE;
    }
}

class B extends A{

}
