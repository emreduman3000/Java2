package exceptions.throw_throws_tryCatch;

import java.io.IOException;
import java.sql.SQLDataException;

public class Exceptionss
{
    public static void main(String[] args) throws IOException, SQLDataException {//method4() için eklendi
        //dikkatli ol cagırdıgım methodlardan bitanesi exception barındırabilir demek için
        //throws eklendi

        try{
            method();//unchecked error oldugu için compile time değil runtime exception barındırır,
            //calıstırmadan exception olup olmadıgı anlayamayız.
            //ona gore try catch i biz koyarız
        }catch (Exception e){
            System.out.println(e);//java.lang.ArithmeticException: / by zero
        }

        method2();//try catch methodun içinde
        //java.lang.NullPointerException: null exception
        //null exception

        method3();//unchecked errror barıdırdığı için compile zamanında anlamayız
        //java.lang.NullPointerException: NullPointerException

        try {
            method4();//unchecked exception barındırır haberiniz olsun diye uyarı içren bir method
            //oyuzden throws IOException eklendi main methoda
            //error meydana gelince try catch a al dedi
        } catch (IOException e) {
            System.out.println(e);//java.io.IOException: File not found
        }

        method5();//SQLDataException fırlatmadı

    }

    private static void method(){
        int i=5/0;
    }

    private static void method2() {
        try {
            throw new NullPointerException("null exception");
        }catch (Exception E){
            System.out.println(E);
            System.out.println(E.getMessage());
        }
    }

    private static void method3() throws NullPointerException{//dikkat et Null... olusabiir
        try {
            NullPointerException nullPointerException=new NullPointerException("NullPointerException");
            throw  nullPointerException;
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static void method4() throws IOException {//dikkat et Null... olusabiir
        IOException ioException=new IOException("File not found");
        throw ioException;

        //throws varsa try catch kullanmak mantıksızdır
    }

    private static void method5() throws SQLDataException {
        //throw new SQLDataException("SQLLL");
        System.out.println("SQLDataException fırlatmadı");
    }
}
