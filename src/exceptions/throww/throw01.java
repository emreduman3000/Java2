package exceptions.throww;

public class throw01 {

    static void fun()
    {
        try
        {
            throw new NullPointerException("demo");
        }
        catch(NullPointerException e)//yukardaki throw burda yakalandı
        {
            System.out.println("Caught inside fun().");
            System.out.println(e);
            throw e; // rethrowing the exception
            //burdaki throw main()'de yakalandı
        }
    }

    public static void main(String args[])
    {
        try
        {
            fun();//bunu yazarken runtime-unchecked exception oldugu icin
            //try catch yaz diye zorlamıyor
        }
        catch(NullPointerException e)
        {
            System.out.println("Caught in main.");
        }

    }

}
