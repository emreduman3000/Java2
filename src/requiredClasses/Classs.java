package requiredClasses;

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;

public class Classs {

    /*
    Java provides a class with name Class in java.lang package.
    Instances of the class Class represent classes and interfaces in a running Java application.
    The primitive Java types (boolean, byte, char, short, int, long, float, and double), and the keyword void are also represented as Class objects.
    It has no public constructor. Class objects are constructed automatically by the Java Virtual Machine(JVM).
    It is a final class, so we cannot extend it.

    The Class class methods are widely used in Reflection API.

    Creating a Class object


     */


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {


        getClassName();

        toStringg();

        newInstance();

        isInstance();

        isAssignableFrom();

        isInterface();

        isPrimitive();

        isArray();

        isEnum();

        Class c=String.class;
        c.isMemberClass();
        c.isLocalClass();
        c.isAnonymousClass();

        System.out.println(c.getName());//java.lang.String
        System.out.println(c.getSimpleName());//String

        getClassLoader();

        getTypeParameters();

        getSuperclass();
        // getGenericSuperclass()

        getInterfaces();
        // getGenericInterfaces()

        getPackage();

        getFields();

    }


    static void getClassName() throws ClassNotFoundException {

        //  There are three ways to create Class object :
        //
        //  Class.forName(“className”) :
        //   Since class Class doesn’t contain any constructor, there is static factory method present in class Class,
        //   which is Class.forName() , used for creating object of class Class. Below is the syntax :

        Class c = Class.forName("requiredClasses.A");//1
        System.out.println(c);//class requiredClasses.A


        //2- Myclass.class : When we write .class after a class name, it references the Class object that represents the given class.
        //It is mostly used with primitive data types and only when we know the name of class.
        // The class name for which Class object is to be created is determined at compile-time.
        // Below is the syntax :
        Class c1 = int.class;
        System.out.println(c1);//int
        c1 = void.class;
        System.out.println(c1);//void


        A a = new A();   // Any class A
        Class c2 = A.class; // No error
        System.out.println(c2);//class requiredClasses.A

        //Class c3 = a.class; // Error


        //obj.getClass() :
        // This method is present in Object class.
        // It return the run-time class of this(obj) object.
        // Below is the syntax :

        A a2 = new A();   // Any class A
        Class c3 = a2.getClass();
        System.out.println(c3);//class requiredClasses.A

    }

    static void toStringg() {
        //public String toString()
        Class c=A.class;
        String A=c.toString();
        System.out.println(A);//class requiredClasses.A
    }

    static void newInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    //T newInstance() :
    // This method creates a new instance of the class represented by this Class object.

    Class myClass = Class.forName("requiredClasses.A");

    Object obj = myClass.newInstance();

    System.out.println("Class of obj : " + obj.getClass());
    //Class of obj : class requiredClasses.A
}

    static void isAssignableFrom() throws ClassNotFoundException {
    //boolean isAssignableFrom(Class<?> cls) :
    // This method determines if the class or interface represented by this Class object is either the same as,
    // or is a superclass or superinterface, of the class or interface represented by the specified Class parameter.
    // returns the Class object for this class
    Class myClass2 = Class.forName("requiredClasses.A");

    // returns the Class object for the class
    // with the specified name
    Class c1 = Class.forName("java.lang.Thread");
    Class c2 = Class.forName("java.lang.String");

    // isAssignableFrom method on c1
    // it checks whether Thread class is assignable from Test
    boolean b4 = c1.isAssignableFrom(myClass2);

    // isAssignableFrom method on c2
    // it checks whether String class is assignable from Test
    boolean b5 = c2.isAssignableFrom(myClass2);

    System.out.println("is Thread class Assignable from Test : " + b4);
    System.out.println("is String class Assignable from Test : " + b5);

    //is Thread class Assignable from Test : false
        //is String class Assignable from Test : false


}

    static void isInstance() throws ClassNotFoundException {


//boolean isInstance(Object obj) :
// This method determines if the specified Object is assignment-compatible with the object represented by this Class

        Class c3 = Class.forName("java.lang.String");

        String s = "GeeksForGeeks";
        int i = 10;
        // checking for Class instance
        // isInstance method
        boolean b1 = c3.isInstance(s);
        boolean b2 = s instanceof String;
        boolean b3 = c3.isInstance(i);

        System.out.println("is s instance of String : " + b1);
        System.out.println("is i instance of String : " + b2);
        System.out.println("is i instance of String : " + b3);

        /*
        is s instance of String : true
        is i instance of String : true
        is i instance of String : false

         */

    }

    private static void isInterface() throws ClassNotFoundException {
        // returns the Class object for the class
        // with the specified name
        Class c1 = Class.forName("java.lang.String");
        Class c2 = Class.forName("java.lang.Runnable");

        // checking for interface type

        // isInterface method on c1
        boolean b1 = c1.isInterface();

        // is Interface method on c2
        boolean b2 = c2.isInterface();

        System.out.println("is java.lang.String an interface : " + b1);
        System.out.println("is java.lang.Runnable an interface : " + b2);
        //is java.lang.String an interface : false
        //is java.lang.Runnable an interface : true
    }

    private static void isPrimitive() throws ClassNotFoundException {
        // returns the Class object associated with an integer;
        Class c1 = int.class;

        // returns the Class object associated with Test class
        Class c2 = A.class;

        // checking for primitive type

        // isPrimitive method on c1
        boolean b1 = c1.isPrimitive();

        // isPrimitive method on c2
        boolean b2 = c2.isPrimitive();

        System.out.println("is "+c1.toString()+" primitive : " + b1);
        System.out.println("is "+c2.toString()+" primitive : " + b2);

        //is int primitive : true
        //is class requiredClasses.A primitive : false
    }

    private static void isArray() throws ClassNotFoundException {
        int a[] = new int[2];

        // returns the Class object for array class
        Class c1 = a.getClass();

        // returns the Class object for Test class
        Class c2 = A.class;

        // checking for array type

        // isArray method on c1
        boolean b1 = c1.isArray();

        // is Array method on c2
        boolean b2 = c2.isArray();

        System.out.println("is "+c1.toString()+" an array : " + b1);
        System.out.println("is "+c2.toString()+" an array : " + b2);

        //is class [I an array : true
        //is class requiredClasses.A an array : false

    }

    private static void isEnum() throws ClassNotFoundException {

        enum Color
        {
            RED, GREEN, BLUE;
        }


        // returns the Class object associated with Color(an enum class)
        Class c1 = Color.class;//enum
         c1 = A.Color.class;//enum

        // returns the Class object associated with Test class
        Class c2 = A.class;

        // checking for Enum class
        // isEnum method
        boolean b1 = c1.isEnum();
        boolean b2 = c2.isEnum();

        System.out.println("is "+c1.toString()+" an Enum class : " + b1);
        System.out.println("is "+c2.toString()+" an Enum class : " + b2);

        //is class requiredClasses.Classs$1Color an Enum class : true
        //is class requiredClasses.A an Enum class : false
    }

    public static void getClassLoader() throws ClassNotFoundException {
        //ClassLoader getClassLoader() : This method returns the class loader for this class. If the class loader is bootstrap classloader then this method returned null, as bootstrap classloader is implemented in native languages like C, C++.
        //If this object represents a primitive type or void,then also null is returned.

        // returns the Class object for this class
        Class myClass = Class.forName("requiredClasses.A");


        // returns the Class object for the class
        // with the specified name
        Class c1 = Class.forName("java.lang.String");

        // returns the Class object for primitive int
        Class c2 = int.class;

        System.out.print("Test class loader : ");

        // getting the class loader for Test class
        // getClassLoader method on myClass
        System.out.println(myClass.getClassLoader());

        System.out.print("String class loader : ");

        // getting the class loader for String class
        // we will get null as String class is loaded
        // by BootStrap class loader
        // getClassLoader method on c1
        System.out.println(c1.getClassLoader());

        System.out.print("primitive int loader : ");

        // getting the class loader for primitive int
        // getClassLoader method on c2
        System.out.println(c2.getClassLoader());

        //Test class loader : jdk.internal.loader.ClassLoaders$AppClassLoader@3764951d
        //String class loader : null
        //primitive int loader : null

    }

    public static void getTypeParameters() throws ClassNotFoundException {
        //TypeVariable<Class<T>>[ ] getTypeParameters() :
        // This method returns an array of TypeVariable objects that represent the type variables declared by the generic declaration represented by this GenericDeclaration object, in declaration order

        // returns the Class object for the class
        // with the specified name
        Class c = Class.forName("java.util.Set");

        // getting array of TypeVariable for myClass object
        // getTypeParameters method
        TypeVariable[] tv = c.getTypeParameters();

        System.out.println("TypeVariables in "+c.getName()+" class : ");

        // iterating through all TypeVariables
        for (TypeVariable typeVariable : tv)
        {
            System.out.println(typeVariable);
        }

        //TypeVariables in java.util.Set class :
        //E

    }

    public static void getSuperclass()throws ClassNotFoundException {
        // returns the Class object associated with Test class
        Class myClass = A.class;

        // returns the Class object for the class
        // with the specified name
        Class c1 = Class.forName("requiredClasses.A");
        Class c2 = Class.forName("requiredClasses.B");
        Class c3 = Class.forName("java.lang.Object");

        // getSuperclass method returns the superclass of the class represented
        // by this class object

        System.out.print("Test superclass : ");

        // getSuperclass method on myClass
        System.out.println(myClass.getSuperclass());

        System.out.print("A superclass : ");

        // getSuperclass method on c1
        System.out.println(c1.getSuperclass());

        System.out.print("B superclass : ");

        // getSuperclass method on c2
        System.out.println(c2.getSuperclass());

        System.out.print("Object superclass : ");

        // getSuperclass method on c3
        System.out.println(c3.getSuperclass());

        //Test superclass : class java.lang.Object
        //A superclass : class java.lang.Object
        //B superclass : class requiredClasses.A
        //Object superclass : null

    }

    public static void getInterfaces()throws ClassNotFoundException {
        //Class<?>[] getInterfaces() : This method returns the interfaces implemented by the class or interface represented by this object.
        //If this object represents a class or interface that implements no interfaces, the method returns an array of length 0.
        //If this object represents a primitive type or void, the method returns an array of length 0.

        // returns the Class object for the class
        // with the specified name
        Class c1 = Class.forName("requiredClasses.A");
        Class c2 = Class.forName("java.lang.String");

        // getInterface method on c1
        // it returns the interfaces implemented by B class
        Class c1Interfaces[] = c1.getInterfaces();

        // getInterface method on c2
        // returns the interfaces implemented by String class
        Class c2Interfaces[] = c2.getInterfaces();


        System.out.println("interfaces implemented by A class : ");

        // iterating through B class interfaces
        for (Class class1 : c1Interfaces)
        {
            System.out.println(class1);
        }


        System.out.println("interfaces implemented by String class : ");

        // iterating through String class interfaces
        for (Class class1 : c2Interfaces)
        {
            System.out.println(class1);
        }

        //interfaces implemented by A class :
        //interface requiredClasses.C

        //interfaces implemented by String class :
        //interface java.io.Serializable
        //interface java.lang.Comparable
        //interface java.lang.CharSequence
        //interface java.lang.constant.Constable
        //interface java.lang.constant.ConstantDesc

    }

    public static void getPackage()throws ClassNotFoundException {
        //Package getPackage() : This method returns the package for this class.
        // The classloader subsystem in JVM Architecture used this method to find the package of a class or interface.

        // returns the Class object for the class
        // with the specified name
        Class c1 = Class.forName("java.lang.String");
        Class c2 = Class.forName("java.util.ArrayList");
        Class c3 = Class.forName("requiredClasses.A");
        Class c4 = Class.forName("requiredClasses.C");

        // getting package of class

        // getPackage method on c1
        System.out.println(c1.getPackage());

        // getPackage method on c2
        System.out.println(c2.getPackage());

        System.out.println(c3.getPackage());
        System.out.println(c4.getPackage());

        //package java.lang
        //package java.util
        //package requiredClasses
        //package requiredClasses

    }


    public static void getFields()throws ClassNotFoundException {
       //Field[] getFields() : This method returns an array of Field objects reflecting all the accessible public fields of the class(and of all its superclasses)
        // or interface(and of all its superclasses) represented by this Class object.

        // returns the Class object for the class
        // with the specified name
        Class c1 = Class.forName("java.lang.Integer");
        Class c2 = Class.forName("requiredClasses.A");

        // getFields method on c1
        // it array of fields of Integer class
        Field F[] = c1.getFields();
        Field F2[] = c2.getFields();

        System.out.println("Below are the fields of Integer class : ");

        // iterating through all fields of  String class
        for (Field field : F)
        {
            System.out.println(field);
        }

        System.out.println("Below are the fields of A class : ");

        // iterating through all fields of  String class
        for (Field field : F2)
        {
            System.out.println(field);
        }


        //Below are the fields of Integer class :
        //public static final int java.lang.Integer.MIN_VALUE
        //public static final int java.lang.Integer.MAX_VALUE
        //public static final java.lang.Class java.lang.Integer.TYPE
        //public static final int java.lang.Integer.SIZE
        //public static final int java.lang.Integer.BYTES

        //Below are the fields of A class :
        //public static final java.lang.String requiredClasses.A.Afield
    }


}