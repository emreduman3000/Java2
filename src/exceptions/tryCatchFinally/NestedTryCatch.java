package exceptions.tryCatchFinally;

public class NestedTryCatch
{
    public static void main(String[] args)
    {

        String[] array={"abc","123",null,"a"};
        for(int i=0;i<6;i++) {
            try {
                int number = array[i].length() + Integer.parseInt(array[i]);
                //there are more than 1 exception
            } catch (Exception e) {
                System.out.println(e);
                //java.lang.NumberFormatException: For input string: "abc"
                //java.lang.NullPointerException: Cannot invoke "String.length()" because "s" is null
                //java.lang.NumberFormatException: For input string: "a"
                //java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
                //java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 4
            }

        }
        System.out.println("\n--------------------------------------------------------\n");

        for(int i=0;i<6;i++) {
                try {
                    int number = array[i].length() + Integer.parseInt(array[i]);
                    //there are more than 1 exception
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    //java.lang.NumberFormatException: For input string: "a"
                    //java.lang.NumberFormatException: For input string: "abc"
                } catch (NullPointerException e) {
                    System.out.println(e);
                    //java.lang.NullPointerException: Cannot invoke "String.length()" because "array[i]" is null
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e);
                    //java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
                    //java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 4
                }
            }
        System.out.println("\n--------------------------------------------------------\n");

        for(int i=0;i<6;i++)
        {
            try{
                int number=array[i].length()+Integer.parseInt(array[i]);
                //there are more than 1 exception
            }catch (ArrayIndexOutOfBoundsException | NumberFormatException | NullPointerException e) {
                System.out.println(e);
               //java.lang.NumberFormatException: For input string: "abc"
                //java.lang.NullPointerException: Cannot invoke "String.length()" because "array[i]" is null
                //java.lang.NumberFormatException: For input string: "a"
                //java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
                //java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 4
            }
        }
        System.out.println("\n--------------------------------------------------------\n");

        String[] array2={"abc","123",null,"a"};
        for(int i=0;i<6;i++) {
            try {
                int number = array[i].length() + Integer.parseInt(array[i]);
                //there are more than 1 exception
            } catch (Exception e) {
                System.out.println(e);
            }
            /*
            catch (ArrayIndexOutOfBoundsException | NumberFormatException | NullPointerException e) {
                System.out.println(e);
            }
             */
        }
        System.out.println("\n--------------------------------------------------------\n");

        for(int i=0;i<6;i++) {
            try {
                int number = array[i].length() + Integer.parseInt(array[i]);
                //there are more than 1 exception
            } catch (NullPointerException e) { //exception her errroru exceptionı bulur
                System.out.println(e);
            } catch (Throwable throwable) {//bu blogu atlar
                System.out.println(throwable + "Throwable calıstı");
            }
        }

        System.out.println("\n--------------------------------------------------------\n");
        for(int i=0;i<6;i++) {
            try {
                int number = array[i].length() + Integer.parseInt(array[i]);
                //there are more than 1 exception
            } catch (Exception e) { //exception her errroru exceptionı bulur
                System.out.println(e);
            } catch (Throwable throwable) {//bu blogu atlar
                System.out.println(throwable + "Throwable calıstı");
            }
          //  Throwable  is superinterface of Exception
        }
    }
}
