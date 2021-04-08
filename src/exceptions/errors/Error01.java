package exceptions.errors;



//Errors V/s Exceptions In Java
//
//        Error : An Error “indicates serious problems that a reasonable application should not try to catch.”
//        Both Errors and Exceptions are the subclasses of java.lang.Throwable class. Errors are the conditions which cannot get recovered by any handling techniques. It surely cause termination of the program abnormally. Errors belong to unchecked type and mostly occur at runtime. Some of the examples of errors are Out of memory error or a System crash error.
//
//  Java program illustrating stack overflow error
//  by doing infinite recursion


public class Error01 {

    public static void main(String[] args) {


        StackOverflow.test(5);
        //	at exceptions.errors.StackOverflow.test(Error01.java:35)
    }
}





class StackOverflow {
    public static void test(int i)
    {
        // No correct as base condition leads to
        // non-stop recursion.
        if (i == 0)
            return;
        else {
            test(i++);
        }
    }
}
