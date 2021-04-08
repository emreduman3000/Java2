package exceptions.unchecked_runTime_exc;

public class NumberFormatException01 {
    public static void main(String[] args) {

        //NumberFormatException  - dönüşüm yapamıyor
        try{
            Integer integer=Integer.parseInt("123");
            Integer integer2=Integer.parseInt("123a");
        }catch (Exception e){
            System.out.println(e);
            //java.lang.NumberFormatException: For input string: "123a"
        }
    }
}
