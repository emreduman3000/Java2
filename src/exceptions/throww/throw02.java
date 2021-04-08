package exceptions.throww;

import java.io.IOException;

public class throw02 {

    static void fun() throws IOException {
        try
        {
            throw new IOException("demo");
        }
        catch(IOException e)
        {
            System.out.println("Caught inside fun().");
            throw e; // BUNU YA BURDA YAKALA DIYOR IDE
            //YA DA THROWS ILE SIGNATURE KOY DIYOR METHODA
        }
    }

    public static void main(String args[])
    {
        try
        {
            fun();//CHECKED-COMPILE Exception old. icin
            //try-catch yaz diye zorlar IDE
        }
        catch(IOException e)
        {
            System.out.println("Caught in main.");
        }
    }

}
