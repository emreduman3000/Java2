package exceptions.tryCatchFinally;

public class ExceptionInMethod {
    public static void main(String[] args)
    {
        try{
            findExceptions();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
            //java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
            //hatayı bulur bulmaz method calısmayı bitirir bir daha dögüye gitmez
        }

    }

    private static void findExceptions()
    {

        String[] array={"abc","123",null,"a"};
        for(int i=0;i<6;i++) {

            try {
                int number = array[i].length();
                //there are more than 1 exception

                try {
                     number=Integer.parseInt(array[i]);
                }
                catch (NumberFormatException e) {
                    System.out.println(e);
                    //java.lang.NumberFormatException: For input string: "a"
                    //java.lang.NumberFormatException: For input string: "abc"
                }

            }

            catch (NullPointerException e) {
                System.out.println(e);
                //java.lang.NullPointerException: Cannot invoke "String.length()" because "array[i]" is null
            }
            //burada hatayı bulmaadı ve syste hata verecekken
            //yukarda method yazırılırken bulundu hata
        }
    }
}
