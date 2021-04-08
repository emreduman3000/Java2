package exceptions.creatingaOurOwnExceptions;


// A Class that uses above MyException
public class MyException
{
    // Driver Program
    public static void main(String args[])
    {
        try
        {
            // Throw an object of user defined exception
            throw new MyExceptionn();
        }
        catch (MyExceptionn ex)
        {
            System.out.println("Caught");
            System.out.println(ex.getMessage());
            //Caught
            //null
        }
    }
}


// A Class that represents use-defined expception
class MyExceptionn extends Exception
{

}

