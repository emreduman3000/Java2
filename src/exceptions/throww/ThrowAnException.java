package exceptions.throww;

import exceptions.tryCatchFinally.TryCatchFinally;

public class ThrowAnException {
    public static void main(String[] args)
    {
        //throw e varsa catch e olmak zorunda

        System.out.println(returnTypeMethod());
        //java.lang.ArrayIndexOutOfBoundsException
        //Hi!trycatchfinally

        try {
            System.out.println(returnTypeMethod2());//method içinde exception throw edildi
        }catch (Exception e){
            System.out.println(e);//java.lang.NullPointerException: returnTypeMethod2
        }

    }

    private static String returnTypeMethod() {//throw yaparsa da olur
        String greeting="Hi!";
        try {
            greeting+="try";
            ArrayIndexOutOfBoundsException e=new ArrayIndexOutOfBoundsException();
            throw e;//exceptionı fırlatır   //throwdan sonra code gelemez

            //return greeting; returnden sonra code gelemez
        }
        catch (Exception e){//throw edilen hata catch edildi
            greeting+="catch";
            System.out.println(e);//yazıldı -java.lang.ArrayIndexOutOfBoundsException
            return greeting;//burda da return olmak zorunda, ın case of exception
        }
        finally {//hata olsun olmasın calısır
            greeting+="finally";
            return greeting;//Hi!trycatchfinally
            //CATCH'DEKI return is not executed
        }
    }




    private static String returnTypeMethod2()
    {//throw yaparsa da olur
        String greeting="Hi!";
        throw new NullPointerException("returnTypeMethod2");
        //exceptionı fırlatır   //throwdan sonra code gelemez

        //return greeting; returnden sonra code gelemez
    }
}
