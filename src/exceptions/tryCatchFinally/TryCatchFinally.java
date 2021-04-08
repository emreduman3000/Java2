package exceptions.tryCatchFinally;

import java.lang.reflect.Array;

public class TryCatchFinally {
    public static void main(String[] args)
    {

        //public class Exception extends Throwable {

        try{//firstly try these codes below:
            Integer i =new Integer("asd");//runtime error
            System.out.println(i);
        }
        catch (Exception e){//if any exception error occurs, write type of it
            System.out.println(e);//java.lang.NumberFormatException: For input string: "asd"
            System.out.println(e.toString());//java.lang.NumberFormatException: For input string: "asd"
        }



        int result;
        try{
            result=5/0;
        }
        catch (Exception e){
            System.out.println(e);//java.lang.ArithmeticException: / by zero
        }finally {
            result=5/1;
            System.out.println(result);//5
        }




        try{
            Integer[] array={1,2,3};
            System.out.println(array[5]);
        }catch (Exception e){
            System.out.println(e);//java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
        }



        try{
            Object o =new Object();//burada olay alt üst sınıf casting
            String b=(String) o;
            short s=10;//burda aralık
            int i=s;
        }catch (Exception e){
            System.out.println(e);//java.lang.ClassCastException: class java.lang.Object cannot be cast to class java.lang.String (java.lang.Object and java.lang.String are in module java.base of loader 'bootstrap')
        }finally {
            System.out.println("finally calıstı");//finally calıstı
        }
    }
}
