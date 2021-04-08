package exceptions.creatingaOurOwnExceptions;

import java.util.Scanner;

public class CreateException {

    //Exceptions : An Exception “indicates conditions that a reasonable application might want to catch.”
    //Exceptions are the conditions that occur at runtime and may cause the termination of program.
    // But they are recoverable using try, catch and throw keywords.

    // Exceptions are divided into two catagories :
    // checked and unchecked exceptions.
    // Checked exceptions like IOException known to the compiler at compile time
    // while unchecked exceptions like ArrayIndexOutOfBoundException known to the compiler at runtime.
    // It is mostly caused by the program written by the programmer.

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Please Enter Your Age:");

        int age=0;
        try{
            age=scanner.nextInt();//abc girdim burada error olusursa direk catch bloga gideriz
        }
        catch (Exception e){
            System.out.println(e);//java.util.InputMismatchException yazabilir eger sayı girilmezse
            System.out.println(e.toString());//java.util.InputMismatchException aynısı yazar
        }
        finally
        {
            try
            {
                if(age<0){
                    throw new Exception("age:"+age+" , age can not be negative");
                }
                else System.out.println(age);
            }
            catch (Exception e)
            {
                System.out.println(e);//jjava.lang.Exception: age:-2 , age can not be negative

            }
        }
    }
}
