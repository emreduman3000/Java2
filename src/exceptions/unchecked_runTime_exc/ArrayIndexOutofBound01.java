package exceptions.unchecked_runTime_exc;

public class ArrayIndexOutofBound01 {


    //This type of exception occurs when you try to access an array with an invalid index value.
    // The value you are providing is either negative or beyond the length of the array.

    public static void main(String args[]) {
        try {
            int b[] = new int[6];
            b[8] = 2; // we are trying to access 9th element in an array of size 7
        } catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println ("The array index is out of bound");
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println(e.getClass());
            //The array index is out of bound
            //null
            //Index 8 out of bounds for length 6
            //[Ljava.lang.StackTraceElement;@4769b07b
            //class java.lang.ArrayIndexOutOfBoundsException
        }
    }
}