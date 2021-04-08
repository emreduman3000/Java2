package exceptions.tryCatchFinally;

public class ReturnTypeMethod {
    public static void main(String[] args) {

        System.out.println(returnTypeMethod());//Hi!tryfinally
        System.out.println(returnTypeMethod2());//Hi!tryfinally
        System.out.println(returnTypeMethod3());//Hi!try

    }

    private static String returnTypeMethod() {
        String greeting="Hi!";
        try {
            greeting+="try";
            return greeting;
        }
        catch (Exception e){
            greeting+="catch";
            return greeting;//burda da return olmak zorunda, ın case of exception
        }
        finally {//hata olsun olmasın calısır
            greeting+="finally";
            return greeting; //sadece burdaki return calısır
        }
    }

    private static String returnTypeMethod2() {
        String greeting="Hi!";
        try {
            greeting+="try";
            //return greeting;
        }
        catch (Exception e){
            greeting+="catch";
            //return greeting;//burda da return olmak zorunda, ın case of exception
        }
        finally {//hata olsun olmasın calısır
            greeting+="finally";
            return greeting;//method return edecek bır sey buldu kendısıne
        }
    }



    private static String returnTypeMethod3() {
        String greeting="Hi!";
        try {
            greeting+="try";
            return greeting;//hata almazsa bu
        }
        catch (Exception e){
            greeting+="catch";
            return greeting;//alırsa bu calıscak method kendısnı saglama aldı
        }
        finally {//hata olsun olmasın calısır
            greeting+="finally";
            //return greeting;//method return edecek bır sey buldu kendısıne
        }
    }

}
