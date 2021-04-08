package exceptions.unchecked_runTime_exc;

import java.io.File;

public class IllegalArgumentException01 {


    //This type of exception occurs whenever an inappropriate or incorrect argument is passed to a method.
    // For example, if a method is defined with non-empty string as parameters.
    // But you are providing null input strings.
    // Then, the IllegalArgumentException is thrown to indicate the user that you cannot pass a null input string to the method.

      //  Consider the following code snippet to demonstrate this type of exception:


    public static void main(String[] args) {
        // This command will be successfully executed.
        System.out.println(IllegalArgumentException01.createRelativePath("dir1", "file1"));
        System.out.println();

        // This command will throw an IllegalArgumentException.
        System.out.println(IllegalArgumentException01.createRelativePath(null, "file1"));
    }

    public static String createRelativePath(String par, String f_name) {
        try {
            if (par == null)
                throw new IllegalArgumentException("You cannot provide null parent path!");

            if (f_name == null)
                throw new IllegalArgumentException("Please enter the complete filename!");

            return par + File.separator + f_name;
        }catch (Exception e){
            System.out.println(e);
            return "";
        }
    }
    //Exception in thread "main" java.lang.IllegalArgumentException: You cannot provide null parent path!

}
