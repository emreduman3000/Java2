package exceptions.creatingaOurOwnExceptions;

import java.util.Scanner;

public class CreateException2 {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Please Enter Your Age:");

        int age=0;
        try{
            age=scanner.nextInt();//abc girdim burada error olusursa direk catch bloga gideriz
        }
        catch (Exception e){
            System.out.println(e);//java.util.InputMismatchException yazabilir eger sayı girilmezse
        }
        finally
        {
            try
            {
                if(age<0){// 2 TANE AYNI ANDA THROW OLMAZ
                    //throw new NegativeAgeException();//NegativeAgeException:
                    throw new NegativeAgeException(age," bir negative sayıdır. salak mısın sen?");
                }
                else System.out.println(age);
            }
            catch (Exception e)
            {
                System.out.println(e);//NegativeAgeException: -2 bir negative sayıdır. salak mısın sen?

            }
        }
    }
}

class NegativeAgeException extends Exception
{
    String exception="NegativeAgeException: ";

    public NegativeAgeException() {
    }

    public NegativeAgeException(int i,String message){
        this.exception+=i+message;
    }

    @Override
    public String toString() {
        return exception;
    }
}
