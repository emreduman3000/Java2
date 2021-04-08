package exceptions.checked_compileTime_exc;

public class ClassNotFoundException01 {

    //This type of exception is thrown when the JVM is not able to find the required class.
    // It may be due to a command-line error, a classpath issue, or a missing .class file.
    // For example, consider the following code snippet:


    private static final String CLASS_TO_LOAD = "main.java.Utils";
    private static final String CLASS_TO_LOAD2 = "exceptions.checked_compileTime_exc.ClassNotFoundException01";

    public static void main(String[] args)
    {
        try {
            Class loadedClass = Class.forName(CLASS_TO_LOAD2);
            System.out.println("Class " + loadedClass + " found!");
            //Class class exceptions.checked_compileTime_exc.ClassNotFoundException01 found!
        } catch (ClassNotFoundException ex) {
            System.err.println("ClassNotFoundException was found: " + ex.getMessage());
            ex.printStackTrace();
        }


        try {
            Class loadedClass = Class.forName(CLASS_TO_LOAD);
            System.out.println("Class " + loadedClass + " found!");
        } catch (ClassNotFoundException ex) {
            System.err.println("ClassNotFoundException was found: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}