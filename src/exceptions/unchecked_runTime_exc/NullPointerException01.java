package exceptions.unchecked_runTime_exc;


public class NullPointerException01 {

    public static void main(String args[]) {
        try {
            String a1 = null; // null value
            System.out.println(a1.charAt(0));
        } catch(NullPointerException e) {
            System.out.println("NullPointerException is found in the program.");
        }


        try {
            System.out.println(Test.name.length() );
        } catch(NullPointerException e) {
            System.out.println(e);
        }
        //java.lang.NullPointerException: Cannot invoke "String.length()"
        // because "exceptions.unchecked_runTime_exc.Test.name" is null
    }



}

