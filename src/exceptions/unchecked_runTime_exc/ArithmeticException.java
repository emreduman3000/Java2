package exceptions.unchecked_runTime_exc;

public class ArithmeticException {
    public static void main(String[] args) {

        //ArithmeticException
        try{
            int divide=10/0;
        }catch (Exception e){
            System.out.println(e);//java.lang.ArithmeticException: / by zero
        }
    }
}
